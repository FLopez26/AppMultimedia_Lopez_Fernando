package com.example.appmultimedia_lopez_fernando.di

import com.example.appmultimedia_lopez_fernando.data.source.remote.GameFirestoreRepository
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.AddGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.GamesUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.GetGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.ModifyGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.RemoveGameUseCase
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.AddGameViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.GamesScreenViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.ModifyGameViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.RemoveGameViewModel
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { FirebaseFirestore.getInstance() }

    single<GameRepository> { GameFirestoreRepository(get()) }

    factory{AddGameUseCase(get())}
    factory{GamesUseCase(get())}
    factory{RemoveGameUseCase(get())}
    factory{ModifyGameUseCase(get())}
    factory{GetGameUseCase(get())}

    viewModel { AddGameViewModel(get()) }
    viewModel { GamesScreenViewModel(get()) }
    viewModel { RemoveGameViewModel(get()) }
    viewModel { ModifyGameViewModel(get(), get()) }
}