package com.example.ejercicio2

class User {
    lateinit var name: String
    lateinit var user: String
    lateinit var passwordRegister: String
    lateinit var email:String

    constructor(name: String, user: String, passwordRegister: String, email: String) {
        this.name = name
        this.user = user
        this.passwordRegister = passwordRegister
        this.email = email
    }
}