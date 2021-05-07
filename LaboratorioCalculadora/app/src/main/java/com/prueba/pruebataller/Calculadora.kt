package com.prueba.pruebataller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Calculadora : AppCompatActivity() {
    lateinit var Resultado: TextView
    lateinit var btnUno: Button
    lateinit var btnDos: Button
    lateinit var btnTres: Button
    lateinit var btnCuatro: Button
    lateinit var btnCinco: Button
    lateinit var btnSeis: Button
    lateinit var btnSiete: Button
    lateinit var btnOcho: Button
    lateinit var btnNueve: Button
    lateinit var btnCero: Button
    lateinit var btnMenos: Button
    lateinit var btnMultiplicar: Button
    lateinit var btnMas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        Resultado = findViewById(R.id.Resultado)
        btnUno = findViewById(R.id.btnUno)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnCuatro = findViewById(R.id.btnCuatro)
        btnCinco = findViewById(R.id.btnCinco)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnTres = findViewById(R.id.btnTres)
        btnMas = findViewById(R.id.btnMas)

        btnUno.setOnClickListener{
            Resultado.text = "1"
        }
        btnDos.setOnClickListener{
            Resultado.text = "2"
        }
        btnTres.setOnClickListener{
            Resultado.text = "3"
        }

    }
}