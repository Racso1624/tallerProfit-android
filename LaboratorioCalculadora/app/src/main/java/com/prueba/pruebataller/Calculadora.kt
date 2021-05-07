package com.prueba.pruebataller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Calculadora : AppCompatActivity() {
    lateinit var tvOne : TextView
    lateinit var tvTwo : TextView
    lateinit var tvThree : TextView
    lateinit var tvFour : TextView
    lateinit var tvFive : TextView
    lateinit var tvSix : TextView
    lateinit var tvSeven : TextView
    lateinit var tvEight : TextView
    lateinit var tvNine : TextView
    lateinit var tvZero : TextView
    lateinit var tvDot : TextView
    lateinit var tvPlus : TextView
    lateinit var tvMinus : TextView
    lateinit var tvMul : TextView
    lateinit var tvDivide : TextView
    lateinit var tvOpen : TextView
    lateinit var tvClose : TextView
    lateinit var tvClear : TextView
    lateinit var tvExpression : TextView
    lateinit var tvResult : TextView
    lateinit var tvBack : TextView
    lateinit var tvEquals : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        tvOne = findViewById(R.id.btnUno)
        tvTwo = findViewById(R.id.btnDos)
        tvThree = findViewById(R.id.btnTres)
        tvFour = findViewById(R.id.btnCuatro)
        tvFive = findViewById(R.id.btnCinco)
        tvSix = findViewById(R.id.btnSeis)
        tvSeven = findViewById(R.id.btnSiete)
        tvEight = findViewById(R.id.btnOcho)
        tvNine = findViewById(R.id.btnNueve)
        tvZero = findViewById(R.id.btnCero)
        tvDot = findViewById(R.id.btnPunto)
        tvPlus = findViewById(R.id.btnMas)
        tvMinus = findViewById(R.id.btnMenos)
        tvMul = findViewById(R.id.btnMultiplicar)
        tvDivide = findViewById(R.id.btnDividir)
        tvOpen = findViewById(R.id.btnParentesisA)
        tvClose = findViewById(R.id.btnParentesisC)
        tvClear = findViewById(R.id.btnBorrar)
        tvExpression = findViewById(R.id.Expresion)
        tvResult = findViewById(R.id.Resultado)
        tvBack = findViewById(R.id.btnEliminar)
        tvEquals = findViewById(R.id.btnIgual)

        tvOne.setOnClickListener { appendOnExpression("1", true) }
        tvTwo.setOnClickListener { appendOnExpression("2", true) }
        tvThree.setOnClickListener { appendOnExpression("3", true) }
        tvFour.setOnClickListener { appendOnExpression("4", true) }
        tvFive.setOnClickListener { appendOnExpression("5", true) }
        tvSix.setOnClickListener { appendOnExpression("6", true) }
        tvSeven.setOnClickListener { appendOnExpression("7", true) }
        tvEight.setOnClickListener { appendOnExpression("8", true) }
        tvNine.setOnClickListener { appendOnExpression("9", true) }
        tvZero.setOnClickListener { appendOnExpression("0", true) }
        tvDot.setOnClickListener { appendOnExpression(".", true) }
        //Operators
        tvPlus.setOnClickListener { appendOnExpression("+", false) }
        tvMinus.setOnClickListener { appendOnExpression("-", false) }
        tvMul.setOnClickListener { appendOnExpression("*", false) }
        tvDivide.setOnClickListener { appendOnExpression("/", false) }
        tvOpen.setOnClickListener { appendOnExpression("(", false) }
        tvClose.setOnClickListener { appendOnExpression(")", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }
        tvEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvResult.text = longResult.toString()
                } else {
                    tvResult.text = result.toString()
                }
            } catch (exception : Exception) {
                Log.d("Exception"," message : " + exception.message )
            }
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean) {
        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}