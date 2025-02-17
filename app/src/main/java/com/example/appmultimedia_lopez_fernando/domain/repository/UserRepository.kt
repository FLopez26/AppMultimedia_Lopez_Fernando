package com.example.appmultimedia_lopez_fernando.domain.repository

import com.example.appmultimedia_lopez_fernando.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getById(id: String): User?
    fun list(): Flow<List<User>>
    suspend fun save(user: User)
    suspend fun delete(id: String)
}