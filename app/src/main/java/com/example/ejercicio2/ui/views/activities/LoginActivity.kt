package com.example.ejercicio2.ui.views.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2.ui.views.fragment.DialogRegister
import com.example.ejercicio2.databinding.LoginactivityBinding
import com.example.ejercicio2.domain.models.User


class LoginActivity: AppCompatActivity() {
    //Inicializado el binding, un boton y los dos campos, user y password
    private lateinit var binding: LoginactivityBinding

    private lateinit var btnLogin: Button
    private lateinit var textUser: EditText
    private lateinit var textPass: EditText


    //Dos variables que al poner los datos de usuario y password funcionará ya que es un usuariio existente


    //El método onCreate infla el layout utilizando el binding, asociando el layout xml login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()
    }

    private fun initEvent() {
        //Inicializamos cada boton/texto con su id corresponiente al binding
        btnLogin = binding.buttonInicio
        textUser = binding.usuario
        textPass = binding.password

        //Dentro del boton login tenemos.
        //Un if donde si el usuario y password se corresponde al usuario existente llevará al MainActivity, sino es así se irá al else
        //Otro if para el usuario que se ha registrado anteriormente, guarda los datos del usuario en preferencias compartidas y se hace un if si al validar el usuario y contraseña funciona llevará al MainActivity,
        // sino saltará al else y se imprimirá un mensaje de error al acceder
        btnLogin.setOnClickListener {
            val usuario = textUser.text.toString()
            val password = textPass.text.toString()

                val sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE)
                val validacionUsusario = sharedPreferences.getString(usuario, null)

                if (validacionUsusario == password) {
                    // Iniciar sesión exitosamente
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(
                        this,
                        "No se puede acceder, correo o contraseña incorrecta",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        //Si queremos crear una cuenta pulsamos el boton de resgitro
        binding.buttonCrearCuenta.setOnClickListener {
            register()

        }




}
    //Método que al pulsar el boton saldrá un mensaje de registro de usuario,
    fun register(){
        Toast.makeText(this, "Registro de nuevo usuario", Toast.LENGTH_LONG).show()
        //Se crea un dialogo de registro
        //Lambda se ejecuta cuando pulse el boton de aceptar y llama a la funcion okNewUser para los datos que se han guardado del usuario
        val dialog = DialogRegister(){
                user -> okOnNewUser(user)
        }
        //aquí se hace visible el Dialogo Fragment
        dialog.show(supportFragmentManager, "Registro de usuario")

    }
    fun okOnNewUser(user: User){
        //Almacena el usuario registrado y llama al método guardarDatosUsuario para guardar user y password

        val username = user.user
        val password = user.passwordRegister

        guardarDatosUsuario(username, password)



    }
    private fun guardarDatosUsuario(user: String, password: String) {
        // Guarda los datos del usuario en preferencias compartidas
        val sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE)

        //Inicializo variable para modificar las preferencias compartidas
        val editor = sharedPreferences.edit()
        // Guardar los datos del usuario en las preferencias compartidas, utiliza nombre de usuario como clave y contraseña como valo
        editor.putString(user, password)
        //Se aplican los cambios a la variable editor
        editor.apply()
    }



}