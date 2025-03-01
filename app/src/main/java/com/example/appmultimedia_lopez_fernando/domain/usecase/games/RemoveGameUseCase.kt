package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository

class RemoveGameUseCase (
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(id: String): Unit {
        gameRepository.delete(id)
    }
}