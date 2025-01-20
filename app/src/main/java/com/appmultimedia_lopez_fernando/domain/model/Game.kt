package com.appmultimedia_lopez_fernando.domain.model

data class Game (
    val name: String,
    val location: String,
    val type: String,
    val minPlayers: Int,
    val maxPlayers: Int,
    val duration: Int,
    val creator: String)
