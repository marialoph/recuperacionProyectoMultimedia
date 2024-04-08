package com.example.ejercicio2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2.databinding.LoginactivityBinding


class LoginActivity: AppCompatActivity() {
    private lateinit var binding: LoginactivityBinding

    private lateinit var btnLogin: Button
    private lateinit var textUser: EditText
    private lateinit var textPass: EditText

    private val MYUSER = "maria"
    private val MYPASS = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()
    }

    private fun initEvent() {

        btnLogin = binding.buttonInicio
        textUser = binding.usuario
        textPass = binding.password

        btnLogin.setOnClickListener {
            val usuario = textUser.text.toString()
            val password = textPass.text.toString()

            if (usuario == MYUSER && password == MYPASS) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }else {
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
        }

        binding.buttonCrearCuenta.setOnClickListener {
            register()
    }

}
    fun register(){
        Toast.makeText(this, "Registro de nuevo usuario", Toast.LENGTH_LONG).show()
        val dialog = DialogRegister(){
                user -> okOnNewUser(user)
        }
        dialog.show(supportFragmentManager, "Registro de usuario")  //aquí se hace visible el Dialogo Fragment

    }
    fun okOnNewUser(user: User){
        //lógica que debéis hacer para almacenar más adelante ese usuario registrado.

        val username = user.user
        val password = user.passwordRegister

        // Llamar a la función para guardar los datos del usuario
        guardarDatosUsuario(username, password)



    }
    private fun guardarDatosUsuario(user: String, password: String) {
        // Guarda los datos del usuario en preferencias compartidas
        val sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(user, password)  // Guardar nombre de usuario como clave y contraseña como valor
        editor.apply()
    }



}