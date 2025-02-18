package com.example.appmultimedia_lopez_fernando.domain.usecase.users

import com.example.appmultimedia_lopez_fernando.domain.model.User
import com.example.appmultimedia_lopez_fernando.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val userRepository: UserRepository) {
    operator fun invoke(): Flow<List<User>> {
        return userRepository.list()
    }
}