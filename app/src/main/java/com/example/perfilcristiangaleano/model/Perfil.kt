package com.example.myapplication.model

// modelo que representa la informacion del perfil del estudiante
data class Perfil(
    val nombre: String,
    val programa: String,
    val semestre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String,
    val descripcion: String,
    val hobbies: List<String>,
    val pasatiempos: List<String>,
    val deportes: List<String>,
    val intereses: List<String>
)