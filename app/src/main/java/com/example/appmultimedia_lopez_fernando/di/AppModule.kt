package com.example.appmultimedia_lopez_fernando.di

import com.example.appmultimedia_lopez_fernando.data.source.remote.GameFirestoreRepository
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.AddGameUseCase
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.AddGameViewModel
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { FirebaseFirestore.getInstance() }

    single { GameFirestoreRepository(get()) }

    factory{AddGameUseCase(get())}

    viewModel { AddGameViewModel(get()) }
}