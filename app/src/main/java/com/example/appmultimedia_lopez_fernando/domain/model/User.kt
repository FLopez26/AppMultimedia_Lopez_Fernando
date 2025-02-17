package com.example.appmultimedia_lopez_fernando.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class User(
    @DocumentId val id: String = "",
    @PropertyName("user_name") val name: String,
    val password: String,
    @ServerTimestamp val createdAt: Date? = null // Fecha generada automáticamente
) {
    // Constructor vacío necesario para la deserialización
    constructor() : this(name = "", password = "")
}
