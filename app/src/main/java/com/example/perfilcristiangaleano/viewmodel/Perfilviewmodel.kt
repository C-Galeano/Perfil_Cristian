package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Perfil

class PerfilViewModel : ViewModel() {

    // datos del perfil del estudiante
    val perfil = Perfil(
        nombre = "Cristian Galeano",
        programa = "Ingeniería de Sistemas",
        semestre = "5° Semestre",
        edad = 20,
        ciudad = "Chia, Cundinamarca",
        correo = "cristianagaleanop@ucundinamarca.edu.co",
        descripcion = "Estudiante de Ingeniería de Sistemas apasionado por el desarrollo " +
                "de software, la tecnología y la innovación. Me gusta aprender nuevas " +
                "herramientas y construir proyectos que generen impacto.",
        hobbies = listOf(
            "Programar aplicaciones móviles",
            "Escuchar música",
            "Ver series y películas",
            "Jugar videojuegos"
        ),
        pasatiempos = listOf(
            "Explorar nuevas tecnologías",
            "Configurar entornos de desarrollo",
            "Ver documentales de ciencia",
            "Compartir con amigos"
        ),
        deportes = listOf(
            "Fútbol",
            "Ciclismo",
            "Gimnasio"
        ),
        intereses = listOf(
            "Desarrollo de software",
            "Inteligencia Artificial",
            "Videojuegos",
            "Música electrónica"
        )
    )

    // estado para mostrar u ocultar la informacion adicional (interactividad requerida)
    var mostrarInfoAdicional by mutableStateOf(false)
        private set

    // estado para controlar qué sección está expandida
    var seccionExpandida by mutableStateOf("")
        private set

    // alterna la visibilidad de la informacion adicional
    fun toggleInfoAdicional() {
        mostrarInfoAdicional = !mostrarInfoAdicional
    }

    // expande o colapsa una sección específica
    fun toggleSeccion(seccion: String) {
        seccionExpandida = if (seccionExpandida == seccion) "" else seccion
    }
}