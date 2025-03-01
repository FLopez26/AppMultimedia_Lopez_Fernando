package com.example.appmultimedia_lopez_fernando.data.source.remote

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class GameFirestoreRepository(val firestore: FirebaseFirestore): GameRepository {
    private val collection = firestore.collection("games")

    suspend fun getGameById(gameId: String?): Game? {
        return gameId?.let { gameId ->
            try {
                val documentSnapshot = collection.document(gameId).get().await()
                documentSnapshot.toObject(Game::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
    override fun list(): Flow<List<Game>> {
        return callbackFlow {

            val listener = collection
                .orderBy("name", Query.Direction.DESCENDING)
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

    override suspend fun save(game: Game) {
        collection.add(game).await()
    }

    override suspend fun update(game: Game) {
        collection.document(game.id).update(
            "name", game.name,
            "location", game.location,
            "type", game.type,
            "minPlayers", game.minPlayers,
            "maxPlayers", game.maxPlayers,
            "duration", game.duration,
            "creator", game.creator
        ).await()
    }

    override suspend fun delete(id: String): Unit {
        collection
            .document(id)
            .delete()
            .await()
    }
}