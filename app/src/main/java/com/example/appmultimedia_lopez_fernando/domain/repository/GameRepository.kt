package com.example.appmultimedia_lopez_fernando.domain.repository

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun list(): Flow<List<Game>>
    suspend fun save(game: Game)
    suspend fun delete(id: String)
    suspend fun update(game: Game)
    suspend fun getGameById(gameId: String?): Game?
}