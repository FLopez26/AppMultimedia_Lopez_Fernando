package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository
import com.example.appmultimedia_lopez_fernando.domain.model.Game

class AddGameUseCase(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(game: Game): Unit {
        gameRepository.save(game)
    }
}