package org.example.model

import java.util.Date


data class Report(
    val title: String,
    val body: String,
    val publicationDate: Date,
    val tag: List<String>,
    val user: String
) {

    override fun toString(): String {
        return "Titulo: $title\n" +
                "$body\n" +
                "Fecha: $publicationDate\n" +
                "Tags: $tag\n" +
                "Autor: $user"
    }

}