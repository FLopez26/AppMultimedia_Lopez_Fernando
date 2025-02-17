package com.example.appmultimedia_lopez_fernando.domain.model

import com.google.firebase.firestore.DocumentId

data class Game (
    @DocumentId val Id: String = "",
    val name: String = "",
    val location: String = "",
    val type: String = "",
    val minPlayers: Int = 0,
    val maxPlayers: Int = 0,
    val duration: Int = 0,
    val creator: String = ""
) {
    constructor() : this("","","","",0,0,0,"")
}
