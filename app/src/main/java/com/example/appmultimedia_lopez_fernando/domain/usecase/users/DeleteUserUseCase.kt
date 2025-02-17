package com.example.appmultimedia_lopez_fernando.domain.usecase.users

import com.example.appmultimedia_lopez_fernando.data.source.remote.UserFirestoneRepository


class DeleteUserUseCase(private val userRepository: UserFirestoneRepository) {
    // Implementamos la lógica del caso de uso dentro de este método
    suspend operator fun invoke(id: String): Boolean {
        // Lógica del caso de uso
        return userRepository.deleteUser(id)
    }
}