package com.es.jwtSecurityKotlin.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/rutas_protegidas")
class RutaProtegidaController {


    @GetMapping("/recurso1")
    fun getRecursoProtegidoUno () : String {
        return "Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75"
    }

    @GetMapping("/recurso2")
    fun getRecursoProtegidoPublico () : String {
        return "Este recurso puede ser accedido por cualquiera \uD83E\uDD75"
    }

    @GetMapping("/recurso/{id}")
    fun getRecursoProtegido (@PathVariable id: String) : String {
        return "Obtener recurso por su id $id \uD83E\uDD75"
    }

    @DeleteMapping("/recurso/{id}")
    fun deleteRecursoProtegido (@PathVariable id: String) : String {
        return "Eliminar recurso por su id $id \uD83E\uDD75"
    }


    @DeleteMapping("eliminar/{nombre}")
    fun saludarUsuarioAutenticado(authentication: Authentication, @PathVariable nombre: String): String {

        if (authentication.name == nombre) {
            //Ojetivo es saludar al usuario autenticado
            return "Hola, $nombre vas a ser eliminado por ti mismo: ${authentication.name}"
        }

        if (authentication.authorities.any { rol -> rol.authority == "ROLE_ADMIN" }) {
            return "Hola, $nombre vas a ser eliminado por ${authentication.name}"
        }

        return "no has entrado, picha"
    }

}