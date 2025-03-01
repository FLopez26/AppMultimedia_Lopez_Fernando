package com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.RemoveGameUseCase
import kotlinx.coroutines.launch

class RemoveGameViewModel(
    val removeGameUseCase: RemoveGameUseCase
) : ViewModel() {
    fun delete(id: String){
        viewModelScope.launch {
            removeGameUseCase(id)
        }
    }
}