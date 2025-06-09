package com.example.todoapp

//Pasarle parametros al sealed class va a meter ese parametro para todos los objetos
// Pero si solo quermos a uno necesitamos convertirno en un data class
sealed class TaskCategory(var isSelected: Boolean = true) {
    //Un objeto no puede recibir parametros
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}
