package com.prueba.pruebataller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show()

        val btnHello: Button = findViewById(R.id.btnHello)

        btnHello.setOnClickListener {
            val intent: Intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
            finish()
        }
    }
}