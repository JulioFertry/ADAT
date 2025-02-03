package com.example.mongocomp.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

// Si el nombre de la data class no se corresponde con el nombre de la coleccion en mongodb, hay que poner: (collection = "collNoticias")
@Document(collection = "colnoticias")
data class Noticia(
    @Id
    val id: ObjectId?,

    @Field
    val titulo: String,

    @Field
    val cuerpo: String,

    @Field
    val fechaPub: Date,

    @Field(name = "tag")
    val tags: List<String>,

    @Field(name = "user")
    val usuario: String
)