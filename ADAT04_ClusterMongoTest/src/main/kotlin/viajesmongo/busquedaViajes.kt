package viajesmongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.model.Filters
import io.github.cdimascio.dotenv.dotenv


fun searchByOrigin() {

    val dotenv = dotenv()
    val connectString = dotenv["URL_MONGODB"]
    val mongoClient: MongoClient = MongoClients.create(connectString)
    val databaseName = "viajesbd"

    try {
        val database = mongoClient.getDatabase(databaseName)
        val collection = database.getCollection("reservas_viaje")
        val filtroBuscarPorNombre = Filters.eq("origen", "Madrid")
        val busqueda1 = collection.find(filtroBuscarPorNombre)
        busqueda1.forEach {
            println(it)
        }
    } catch (e: Exception) {
        println("Error al conectar a MongoDB: ${e.message}")
    } finally {
        mongoClient.close()
    }

}