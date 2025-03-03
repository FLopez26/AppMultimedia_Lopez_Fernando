package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository

class RandomGameUseCase(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(type: String,minPlayers: Int,maxPlayers: Int,duration: Int,creator: String): Game?{
        return gameRepository.searchGame(type,minPlayers,maxPlayers,duration,creator)
    }
}