package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow

class GamesUseCase(private val gameRepository: GameRepository) {
    operator fun invoke(): Flow<List<Game>> {
        return gameRepository.list()
    }
}