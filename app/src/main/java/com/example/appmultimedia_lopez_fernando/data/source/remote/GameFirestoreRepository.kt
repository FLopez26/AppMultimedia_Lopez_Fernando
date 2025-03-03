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

    override suspend fun getGameById(gameId: String?): Game? {
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

    override suspend fun searchGame(
        type: String?,
        minPlayers: Int?,
        maxPlayers: Int?,
        duration: Int?,
        creator: String?
    ): Game? {
        try {
            var query: Query = collection
            if (!type.isNullOrBlank()) {
                query = query.whereEqualTo("type", type)
            }
            if (!creator.isNullOrBlank()) {
                query = query.whereEqualTo("creator", creator)
            }
            if (minPlayers != null && minPlayers > 0) {
                query = query.whereGreaterThanOrEqualTo("minPlayers", minPlayers)
            }
            if (maxPlayers != null && maxPlayers > 0) {
                query = query.whereLessThanOrEqualTo("maxPlayers", maxPlayers)
            }
            if (duration != null && duration > 0) {
                query = query.whereGreaterThanOrEqualTo("duration", duration - 15)
                query = query.whereLessThanOrEqualTo("duration", duration + 15)
            }

            val querySnapshot = query.get().await()

            if (querySnapshot.isEmpty) {
                return null
            } else {
                val games = mutableListOf<Game>()
                for (document in querySnapshot.documents) {
                    val game = document.toObject(Game::class.java)
                    game?.let { games.add(it) }
                }

                if (games.isNotEmpty()) {
                    if (games.size == 1) {
                        return games[0]
                    } else {
                        val randomIndex = (0 until games.size).random()
                        return games[randomIndex]
                    }
                } else {
                    return null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
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