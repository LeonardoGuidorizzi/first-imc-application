package br.senai.sp.jandira.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Criar as variaveis locais utilizadas no Calculo
    var weight = 0
    var height = 0.0
    var bmi = 0.0

    //declarar as views da Activity
    lateinit var buttonCalculate: Button
    lateinit var editWeight: EditText
    lateinit var editHeight: EditText
    lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        // Instancia as Views
        buttonCalculate = findViewById(R.id.button_calculate)
        editWeight = findViewById(R.id.edit_weight)
        editHeight = findViewById(R.id.edit_height)
        textResult = findViewById(R.id.text_view_result)
        //detectar o click do botao
        buttonCalculate.setOnClickListener {

            if (inputValidate()) {
                bmiCalculate()
            }
        }
    }

    private fun inputValidate(): Boolean {
        if (editWeight.text.isEmpty()) {
            editWeight.error = "Weight is required!"
            return false
        }
        if (editHeight.text.isEmpty()) {
            editHeight.error = "Height is required"
            return false
        }
        return true
    }


    private fun bmiCalculate(){
        //Recuperar os valores digitados

        weight = editWeight.text.toString().toInt()
        height = editHeight.text.toString().toDouble()

        //calcular o imc

        bmi = weight / height.pow(2)

        textResult.text = String.format("%.2f", bmi)
    }
}