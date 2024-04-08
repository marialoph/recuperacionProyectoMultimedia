package com.example.ejercicio2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ejercicio2.databinding.RegisteractivityBinding

class DialogRegister (
    val onNewUserDialog: (User)-> Unit
): DialogFragment() {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(activity)
            val inflater = requireActivity().layoutInflater;  //objeto que necesita para inflar vistas
            val viewDialogNewUser = inflater.inflate(R.layout.registeractivity, null) //vista inflada.
            builder.setView(viewDialogNewUser)
                // Add action buttons
                .setPositiveButton("Añadir",
                    DialogInterface.OnClickListener { dialog, id ->
                        val newUser = recoverDataLayout(viewDialogNewUser)
                        if (
                            newUser.name.isNullOrEmpty() ||
                            newUser.user.isNullOrEmpty() ||
                            newUser.passwordRegister.isNullOrEmpty() ||
                            newUser.email.isNullOrEmpty()
                        ){
                            Toast.makeText(activity, "Algún campo está vacío", Toast.LENGTH_LONG).show()
                            getDialog()?.cancel()
                        }else{
                            onNewUserDialog(newUser)
                        }
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("El activity no puede ser nulo")


    }

    private fun recoverDataLayout(view: View): User {
        val binding = RegisteractivityBinding.bind(view) //a partir de la vista inflada, obtenemos el binding.
        return User(
            binding.name.text.toString(),
            binding.user.text.toString(),
            binding.passwordRegister.text.toString(),
            binding.email.text.toString()

        )
    }
}