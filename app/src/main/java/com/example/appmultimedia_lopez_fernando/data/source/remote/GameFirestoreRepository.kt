package com.example.appmultimedia_lopez_fernando.data.source.remote

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class GameFirestoreRepository(val firestore: FirebaseFirestore) {
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

    suspend fun save(game: Game) {
        collection.add(game).await()
    }

    suspend fun update(game: Game) {
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

    suspend fun delete(id: String): Unit {
        collection
            .document(id)
            .delete()
            .await()

    }
}