package com.example.appmultimedia_lopez_fernando.presentation.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmultimedia_lopez_fernando.domain.usecase.users.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsernamePasswordViewModel(
    val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun setUsername(username: String) {
        this._username.value = username;
    }

    fun setPassword(password: String) {
        this._password.value = password;
    }

    fun clear() {
        this._username.value = ""
        this._password.value = ""
    }

    fun login(
        onSuccess: () -> Unit,
        onFail: () -> Unit
    ) {
        viewModelScope.launch {
            if(isValidLogin()) {
                onSuccess()
            } else {
                onFail()
            }
        }
    }
    private suspend fun isValidLogin(): Boolean {
        return loginUseCase(username.value, password.value)
    }
}