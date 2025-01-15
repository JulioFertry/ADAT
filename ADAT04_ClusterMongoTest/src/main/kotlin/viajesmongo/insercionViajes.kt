package viajesmongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.github.cdimascio.dotenv.dotenv
import org.bson.Document
import java.time.Instant


fun createNewDocument(): Document {
    try {
        print("Introduce la ciudad de origen: ")
        val origen = readln()
        print("Introduce la ciudad de destino: ")
        val destino = readln()
        print("Introduce el precio: ")
        val precio = readln().toDouble()
        print("Introduce el numero del mes: ")
        val mes = readln().toInt()
        print("Introduce el numero del dia: ")
        val dia = readln()
        val fecha = "2025-${mes}-${dia}T10:30:00.000Z"
        val newDoc = Document()
            .append("origen", origen)
            .append("destino", destino)
            .append("precio", precio)
            .append("fecha_salida", Instant.parse(fecha))
        return newDoc
    } catch (e: Exception){
        throw IllegalArgumentException("Error al introducir los datos")
    }

}


fun insert() {
    val dotenv = dotenv()
    val connectString = dotenv["URL_MONGODB"]
    val mongoClient: MongoClient = MongoClients.create(connectString)
    val databaseName = "viajesbd"

    try {
        val database = mongoClient.getDatabase(databaseName)
        val collection = database.getCollection("reservas_viaje")
        val nuevoDocumento = createNewDocument()
        collection.insertOne(nuevoDocumento)

    } catch (e: IllegalArgumentException) {
        println(e)
    } catch (e: Exception) {
        println("Error al conectar a MongoDB: ${e.message}")
    } finally {
        mongoClient.close()
    }

}