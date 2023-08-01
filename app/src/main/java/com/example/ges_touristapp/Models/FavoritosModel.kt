package com.example.ges_touristapp.Models

data class Favoritos (

    var id: String? = null,
    var lugar_nameF: String? = null,
    var lugar_direccionF: String? = null,
    var lugar_latitudF: Double = 0.0,
    var lugar_longitudF: Double = 0.0,
    var imagenUrl: String? = ""
)
