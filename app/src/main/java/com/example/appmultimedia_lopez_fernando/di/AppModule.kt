package com.example.appmultimedia_lopez_fernando.di

import com.example.appmultimedia_lopez_fernando.data.source.remote.GameFirestoreRepository
import com.example.appmultimedia_lopez_fernando.data.source.remote.UserFirestoreRepository
import com.example.appmultimedia_lopez_fernando.domain.repository.GameRepository
import com.example.appmultimedia_lopez_fernando.domain.repository.UserRepository
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.AddGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.GamesUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.GetGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.ModifyGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.RandomGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.RemoveGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.users.LoginUseCase
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.AddGameViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.GamesScreenViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.ModifyGameViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.RandomGameViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.RemoveGameViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.login.UsernamePasswordViewModel
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { FirebaseFirestore.getInstance() }

    single<GameRepository> { GameFirestoreRepository(get()) }
    single<UserRepository> { UserFirestoreRepository(get()) }

    factory{AddGameUseCase(get())}
    factory{GamesUseCase(get())}
    factory{RemoveGameUseCase(get())}
    factory{ModifyGameUseCase(get())}
    factory{GetGameUseCase(get())}
    factory{LoginUseCase(get())}
    factory{RandomGameUseCase(get())}

    viewModel { AddGameViewModel(get()) }
    viewModel { GamesScreenViewModel(get()) }
    viewModel { RemoveGameViewModel(get()) }
    viewModel { ModifyGameViewModel(get(), get()) }
    viewModel { UsernamePasswordViewModel(get()) }
    viewModel { RandomGameViewModel(get()) }
}