package com.example.appmultimedia_lopez_fernando.domain.usecase.users

import com.example.appmultimedia_lopez_fernando.domain.repository.UserRepository

class LoginUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(username:String, password:String): Boolean {
        return userRepository.findByUsernamePassword(username, password)
    }
}