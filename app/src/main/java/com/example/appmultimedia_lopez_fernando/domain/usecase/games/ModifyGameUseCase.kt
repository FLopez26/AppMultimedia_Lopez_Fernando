package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository

class ModifyGameUseCase(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(game: Game): Unit {
        gameRepository.update(game)
    }
}