package com.example.appmultimedia_lopez_fernando.data.source.remote

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class GameRepository(val firestore: FirebaseFirestore) {

    private val gamesCollection = firestore.collection("games")

    // Obtener un usuario por ID
    suspend fun getUserById(id: String): Game? {
        return try {
            val documentSnapshot = gamesCollection.document(id).get().await()
            documentSnapshot.toObject(Game::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun list(): Flow<List<Game>> {
        // Esta implementación crea un Flow que actualiza la lista de usuarios
        // cada vez que hay un cambio en la base de datos
        return callbackFlow {

            val listener = gamesCollection
                // Aquí viene la query,
                // Se ordena por nombre de manera desceniente
                .orderBy("name", Query.Direction.DESCENDING)
                // Creamos un listener a la query para que se actualice siempre que haya cambios
                .addSnapshotListener { snapshots, error ->
                    if (error != null) {
                        close(error)
                        return@addSnapshotListener
                    }

                    val items = snapshots?.documents?.mapNotNull { doc ->
                        doc.toObject(Game::class.java)
                    } ?: emptyList()

                    trySend(items)
                }

            awaitClose() { listener.remove() }
        }
    }

    // Agregar un nuevo usuario
    suspend fun addGame(game: Game): Boolean {
        return try {
            gamesCollection.add(game).await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    // Actualizar un usuario existente
    suspend fun updateGame(id: String, game: Map<String, Any>): Boolean {
        return try {
            gamesCollection.document(id).update(game).await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    // Eliminar un usuario por ID
    suspend fun deleteGame(id: String): Boolean {
        return try {
            gamesCollection.document(id).delete().await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}