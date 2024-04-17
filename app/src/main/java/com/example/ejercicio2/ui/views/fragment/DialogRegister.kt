package com.example.ejercicio2.ui.views.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ejercicio2.R
import com.example.ejercicio2.databinding.RegisteractivityBinding
import com.example.ejercicio2.domain.models.User

class DialogRegister (
    //funcion que se ejecuta cuando se quiere registrar un nuevo usuario
    val onNewUserDialog: (User)-> Unit
): DialogFragment() {


    //Método para crear el dialogo
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            //Se crea un constructor de dialogo
            val builder = AlertDialog.Builder(activity)
            //Pra obtener el objeto necesario para inflar vistas
            val inflater = requireActivity().layoutInflater;
            //Infla la vista del dialogo
            val viewDialogNewUser = inflater.inflate(R.layout.registeractivity, null)
            builder.setView(viewDialogNewUser)
                // Agrega botones de accion, añadir y cancelar
                .setPositiveButton("Añadir",
                    DialogInterface.OnClickListener { dialog, id ->
                        //Los datos del nuevo usuario
                        val newUser = recoverDataLayout(viewDialogNewUser)
                        //Verifica si algún campo está vacío
                        if (
                            newUser.name.isNullOrEmpty() ||
                            newUser.user.isNullOrEmpty() ||
                            newUser.passwordRegister.isNullOrEmpty() ||
                            newUser.email.isNullOrEmpty()
                        ){
                            //En caso de que algún campo esté vació se mostrará un mensaje y se cancela el dialogo
                            Toast.makeText(activity, "Algún campo está vacío", Toast.LENGTH_LONG).show()
                            getDialog()?.cancel()
                        }else{
                            //Si estan todos los campos rellenos llama a la funcion onNewUserDialog para registrar el nuevo usuario
                            onNewUserDialog(newUser)
                        }
                    })
                //El botón cancelar
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        //Se cancela con esa función
                        getDialog()?.cancel()
                    })
            //Crea y devuelve el diálogo construido
            builder.create()
        } ?: throw IllegalStateException("El activity no puede ser nulo")


    }

    private fun recoverDataLayout(view: View): User {
        //Se obtiene la vista inflada, gracias el binding.
        val binding = RegisteractivityBinding.bind(view)
        //Devuelve los datos recuperados del diseño
        return User(
            binding.name.text.toString(),
            binding.user.text.toString(),
            binding.passwordRegister.text.toString(),
            binding.email.text.toString()

        )
    }
}