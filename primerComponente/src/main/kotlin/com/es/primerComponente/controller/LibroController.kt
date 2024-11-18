package com.es.primerComponente.controller
import com.es.primerComponente.model.Libro
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody


@RestController
class LibroController {

    private val libros: MutableList<Libro> = mutableListOf(
        Libro(1, "1984", "Distópico", "George Orwell"),
        Libro(2, "El lazarillo de tormes", "Picarescaa", "Anonimo")
    )
    // Vamos a hacer un CRUD de libros
    // Vamos a hacer un método que acepte C (Create) -> POST
    // Vamos a hacer un método que acepte R (Read) -> GET
    // Vamos a hacer un método que acepte U (Update) -> PUT
    // Vamos a hacer un método que acepte D (Delete) -> DELETE


    @PostMapping("/libros")
    fun insert(@RequestBody libroNuevo: Libro): Libro? {
        val libroEnLista = libros.find { l -> l.id == libroNuevo.id }

        if (libroEnLista != null) {
            return null
        } else {
            libros.add(libroNuevo)
            return libros.find { l -> l.id == libroNuevo.id }
        }
    }


    @GetMapping("/libros/{id}")
    fun getById(
        @PathVariable id: String // Captura variables en la URL. Esto se utiliza
    ) : Libro?
    {

        println(id)
        val idL: Long = id.toLong()

        return libros.find { l -> l.id == idL }
    }


    @GetMapping("/libros")
    fun getAll(): List<Libro>?
    {
        return libros
    }


    @PutMapping("/libros")
    fun update(@RequestBody libroActualizado: Libro): Libro? {

        val id = libroActualizado.id

        val libroLista = libros.find { l -> l.id == id }

        return if (libroLista != null) {
            libroLista.id = id
            libroLista.genero = libroActualizado.genero
            libroLista.titulo = libroActualizado.titulo
            libroLista.autor = libroActualizado.autor
            libroLista
        } else {
            null
        }
    }


    @DeleteMapping("/libros/{id}")
    fun deleteById(@PathVariable id: String) {

        println(id)
        val idL: Long = id.toLong()

        val libroEliminado = libros.find { l -> l.id == idL }
        libros.remove(libroEliminado)
    }

}