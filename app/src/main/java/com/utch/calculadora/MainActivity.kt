package com.utch.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UnoButton.setOnClickListener { numeroPresionado(digito = "1") }
        DosButton.setOnClickListener { numeroPresionado(digito = "2") }
        TresButton.setOnClickListener { numeroPresionado(digito = "3") }
        CuatroButton.setOnClickListener { numeroPresionado(digito = "4") }
        CincoButton.setOnClickListener { numeroPresionado(digito = "5") }
        SeisButton.setOnClickListener { numeroPresionado(digito = "6") }
        SieteButton.setOnClickListener { numeroPresionado(digito = "7") }
        OchoButton.setOnClickListener { numeroPresionado(digito = "8") }
        NueveButton.setOnClickListener { numeroPresionado(digito = "9") }
        CeroButton.setOnClickListener { numeroPresionado(digito = "0") }

        SumaButton.setOnClickListener {operacionPresionada(SUMA)}
        RestaButton.setOnClickListener {operacionPresionada(RESTA)}
        MultiplicacionButton.setOnClickListener {operacionPresionada(MULTIPLICACION)}
        DivisionButton.setOnClickListener {operacionPresionada(DIVISION)}

        LimpiarBoton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            ResultadoTextView.text = "0"
            operacion = NO_OPERACION
        }

        IgualButton.setOnClickListener{
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }

            ResultadoTextView.text = resultado.toString()

        }

    }
    private fun numeroPresionado(digito: String){

        ResultadoTextView.text = "${ResultadoTextView.text}$digito"

        if(operacion == NO_OPERACION){
            num1 = ResultadoTextView.text.toString().toDouble()
        }else{
            num2 = ResultadoTextView.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion

        //num1 = ResultadoTextView.text.toString().toDouble()

        ResultadoTextView.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }

}