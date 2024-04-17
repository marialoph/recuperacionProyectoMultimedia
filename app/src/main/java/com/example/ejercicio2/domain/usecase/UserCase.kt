package com.example.ejercicio2.domain.usecase

import com.example.ejercicio2.domain.models.User
import com.example.ejercicio2.domain.models.UserRepository

class UserCase {
    val userRepository= UserRepository()

    // Método para realizar la comprobación de login
    fun loginUser(username: String, password: String): User? {
        return userRepository.login(username, password)
    }

    // Método para realizar un nuevo registro de usuario
    fun registerUser(username: String, password: String, name: String, email: String): User? {
        return userRepository.registerUser(username, password, name, email)
    }
}