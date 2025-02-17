package com.example.appmultimedia_lopez_fernando.domain.repository

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun list(): Flow<List<Game>>
    suspend fun save(product: Game)
    suspend fun delete(id: String)
}