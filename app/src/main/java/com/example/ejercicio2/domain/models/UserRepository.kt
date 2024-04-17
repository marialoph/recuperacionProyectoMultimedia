package com.example.ejercicio2.domain.models

import com.example.ejercicio2.data.users.mem.service.UserService
import  com.example.ejercicio2.data.users.mem.objects.RepositoryObject

class UserRepository {

    private val userService = UserService()


    // Método para verificar el inicio de sesión
    fun login(username: String, password:String): User? {

        return userService.login(username, password)
    }

    // Método para registrar un nuevo usuario
    fun registerUser(username: String, password: String, name:String, email:String): User? {

        return userService.registerUser(username,password, name, email)
    }


}