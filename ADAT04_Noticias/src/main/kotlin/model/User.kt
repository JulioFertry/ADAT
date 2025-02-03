package org.example.model

import org.bson.codecs.pojo.annotations.BsonProperty

data class User(
    val email: String,
    val name: String,
    val nickname: String,
    val state: State,
    @BsonProperty("telefonos")
    val phoneNumbers: List<String>,
    val address: Address
) {
    override fun toString(): String {
        return "$nickname ($state)"
    }
}

enum class State {
    BANNED, ACTIVE, INACTIVE
}