package org.example.model

import java.sql.Date


data class Report(
    val title: String,
    val body: String,
    val publicationDate: Date,
    val tag: List<String>,
    val user: String
)