package com.prueba.pruebataller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Calculadora : AppCompatActivity() {
    lateinit var txtResultado: TextView
    lateinit var btnUno: Button
    lateinit var btnDos: Button
    lateinit var btnTres: Button
    lateinit var btnMas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        txtResultado = findViewById(R.id.txtResultado)
        btnUno = findViewById(R.id.btnUno)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnMas = findViewById(R.id.btnMas)

        btnUno.setOnClickListener{
            txtResultado.text = "1"
        }
        btnDos.setOnClickListener{
            txtResultado.text = "2"
        }
        btnTres.setOnClickListener{
            txtResultado.text = "3"
        }

    }
}