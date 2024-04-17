package com.example.ejercicio2.data.users.mem.service

import com.example.ejercicio2.data.users.mem.objects.RepositoryObject
import com.example.ejercicio2.domain.models.User
import com.example.ejercicio2.domain.models.UserRepository

class UserService{
    val repository=RepositoryObject

    private val listaUsuario = mutableListOf<User>()

    fun loadAllUsers(repository:RepositoryObject){
        listaUsuario.addAll(repository.usuariosRegistrados)
    }

    //Método que inicia sesion con el usuario creado en el repository
    fun login(user: String, password: String): User? {
        val users= RepositoryObject.allUsers()
        return users.find { it.user == user && it.passwordRegister == password }
    }

    // Método que registra un nuevo usuario
    fun registerUser(user: String, password: String, name:String, email:String): User? {
        val newUser = User(name, user, password, email)
        repository.addUser(newUser)
        return newUser
    }
}

