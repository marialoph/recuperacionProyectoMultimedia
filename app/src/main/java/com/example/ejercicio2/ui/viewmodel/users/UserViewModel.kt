package com.example.ejercicio2.ui.viewmodel.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicio2.domain.models.User

class UserViewModel : ViewModel() {


    var listaUser = MutableLiveData<User>()

    fun actualizarUsuario(user: User){
        listaUser.value=user
    }




}