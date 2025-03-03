package com.example.appmultimedia_lopez_fernando.data.source.remote

import com.example.appmultimedia_lopez_fernando.domain.repository.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserFirestoreRepository(val firestore: FirebaseFirestore): UserRepository {
    private val collection = firestore.collection("users")

    override suspend fun findByUsernamePassword(username: String, password: String): Boolean {
        return try {
            val querySnapshot = collection
                .whereEqualTo("user_name", username)
                .whereEqualTo("password", password)
                .get()
                .await()
            return !querySnapshot.isEmpty
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
}