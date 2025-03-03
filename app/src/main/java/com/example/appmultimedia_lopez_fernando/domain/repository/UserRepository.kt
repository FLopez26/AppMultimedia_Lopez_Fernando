package com.example.appmultimedia_lopez_fernando.domain.repository

interface UserRepository {
    suspend fun findByUsernamePassword(username:String, password:String): Boolean
}