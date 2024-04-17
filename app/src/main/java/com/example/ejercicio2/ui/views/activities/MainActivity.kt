package com.example.ejercicio2.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio2.R

//Activity que al loguearse aparecerá una página con un texto realizado en el xml activity_main
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}