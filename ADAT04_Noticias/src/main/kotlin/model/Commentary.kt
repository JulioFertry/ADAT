package org.example.model

import java.util.Date

data class Commentary(
    val user: String,
    val report: String,
    val commentary: String,
    val date: Date
)