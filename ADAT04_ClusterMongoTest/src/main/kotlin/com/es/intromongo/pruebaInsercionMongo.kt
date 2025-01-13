package com.es.intromongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import io.github.cdimascio.dotenv.dotenv
import org.bson.Document

fun main() {

    val dotenv = dotenv()
    val connectString = dotenv["URL_MONGODB"]

    // Configuramos la uri del cluster
    val mongoClient: MongoClient = MongoClients.create(connectString)
    val databaseName = "adaprueba"

    try {
        // Obtener la base de datos
        val database = mongoClient.getDatabase(databaseName)

        // Obtener la colección
        val collection = database.getCollection("collprueba")

        // Establecer diferentes filtros de búsqueda
        val filtroBuscarPorNombre = Filters.eq("nombre", "pepe")

        // Puedo ejecutar la búsqueda
        val busqueda1 = collection.find(filtroBuscarPorNombre)

        // Podemos iterar sobre la búsqueda
        println("EQ")
        busqueda1.forEach {
            println(it)
        }

        // Filtro and lógico -> Queremos buscar los documentos cuya edad sea igual o mayor a 30 y menor a 80
        val filtroBusquedaEdad = Filters.and(
            Filters.gte("edad", 30),
            Filters.lt("edad", 80)
        )

        // Ejecuto la busqueda y la recorro
        println("AND")
        collection.find(filtroBusquedaEdad).forEach { println(it) }

        // Filtro regex -> Encontrar los documentos cuyo email termine en mail.tron
        val filtroRegex = Filters.regex("email", ".*mail.tron$")

        println("REGEX")
        collection.find(filtroRegex).forEach { println(it) }

    } catch (e: Exception) {
        println("Error al conectar a MongoDB: ${e.message}")
    } finally {
        // Cerrar la conexión
        mongoClient.close()
    }


}