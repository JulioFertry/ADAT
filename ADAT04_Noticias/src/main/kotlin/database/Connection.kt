package org.example.database

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.github.cdimascio.dotenv.dotenv
import com.mongodb.client.MongoDatabase


object Connection {

    private val mongoClient: MongoClient by lazy {
        val dotenv = dotenv()
        val connectString = dotenv["URL_MONGODB"]
        MongoClients.create(connectString)
    }

    fun getDatabase(database: String): MongoDatabase {
        return mongoClient.getDatabase(database)
    }

    fun closeConnection() {
        mongoClient.close()
        println("Se ha cerrado la conexión con la Base de Datos")
    }

}