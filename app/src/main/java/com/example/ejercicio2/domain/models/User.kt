package com.example.ejercicio2.domain.models

//Clase user con los atributos necesarios para el registro
class User {
    lateinit var name: String
    lateinit var user: String
    lateinit var passwordRegister: String
    lateinit var email:String


//Constructor con los atributos
    constructor(name: String, user: String, passwordRegister: String, email: String) {
        this.name = name
        this.user = user
        this.passwordRegister = passwordRegister
        this.email = email
    }
}