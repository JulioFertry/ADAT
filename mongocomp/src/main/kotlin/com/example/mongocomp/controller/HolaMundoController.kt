package com.example.mongocomp.controller

import com.example.mongocomp.model.Noticia
import com.example.mongocomp.repository.NoticiaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*

@RestController
class HolaMundoController {

    @Autowired
    private lateinit var noticiaRepository: NoticiaRepository

    @GetMapping()
    fun getHolaMundo() : String {
        val noticia = Noticia(
           null,
            "Noticia1",
            "Tremenda noticia que tenemos",
            Date.from(Instant.now()),
            listOf("Mundo", "Actualidad"),
            "idClientePrueba"
        )

        noticiaRepository.insert(noticia)

        return "<h1> Hola Mundo </>"
    }


}