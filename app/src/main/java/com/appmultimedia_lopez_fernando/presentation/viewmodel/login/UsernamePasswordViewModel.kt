package com.appmultimedia_lopez_fernando.presentation.viewmodel.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UsernamePasswordViewModel : ViewModel() {
    private val VALID_USERNAME = "admin"
    private val VALID_PASSWORD = "admin"

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

    fun isValidLogin(): Boolean {
        return username.value == VALID_USERNAME &&
                password.value == VALID_PASSWORD
    }
}