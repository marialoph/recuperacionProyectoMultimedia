package com.example.ejercicio2.data.users.mem.objects

import com.example.ejercicio2.domain.models.User

object RepositoryObject {

    val usuariosRegistrados : MutableList<User> =mutableListOf()

    init {
        usuariosRegistrados.add(User("maria", "maria", "123", "maria@gmail.com"))
        usuariosRegistrados.add(User("carlos", "carlos", "123", "carlos@hotmail.es"))
        usuariosRegistrados.add(User("elena", "elena", "123", "elena@yahoo.es"))
        usuariosRegistrados.add(User("pablo", "pablo", "123", "pablo@outlook.es"))

    }
    fun allUsers(): List<User>{
        return usuariosRegistrados.toList()
    }

    fun addUser(user:User){
        usuariosRegistrados.add(user)
    }



}