package com.example.peluchitosapp

interface Comunicador {
    fun enviarDatos(id: String, nombre: String, cantidad: String, precio: String)
    fun enviarNombreEliminar(nombreEliminar: String)
}