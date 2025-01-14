package viajesmongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.github.cdimascio.dotenv.dotenv


fun insert() {
    val dotenv = dotenv()
    val connectString = dotenv["URL_MONGODB"]

    // Configuramos la uri del cluster
    val mongoClient: MongoClient = MongoClients.create(connectString)
    val databaseName = "viajesbd"

    
}