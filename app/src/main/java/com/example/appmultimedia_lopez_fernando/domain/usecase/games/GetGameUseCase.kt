package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository

class GetGameUseCase(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(id: String?): Game? {
        return gameRepository.getGameById(id)
    }
}