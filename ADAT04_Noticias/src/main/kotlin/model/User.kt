package org.example.model

import org.bson.codecs.pojo.annotations.BsonProperty

data class User(
    val email: String,
    val name: String,
    val nickname: String,
    val state: Boolean,
    @BsonProperty("telefonos")
    val phoneNumbers: List<String>,
    val address: Address
)