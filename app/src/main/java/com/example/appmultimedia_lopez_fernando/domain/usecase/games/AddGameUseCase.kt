package com.example.appmultimedia_lopez_fernando.domain.usecase.games

import com.example.appmultimedia_lopez_fernando.data.source.remote.GameFirestoreRepository
import com.example.appmultimedia_lopez_fernando.domain.model.Game

class AddGameUseCase(
    private val gameRepository: GameFirestoreRepository
) {
    operator suspend fun invoke(game: Game): Unit {
        gameRepository.save(game)
    }
}