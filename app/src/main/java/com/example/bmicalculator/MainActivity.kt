package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.edtTxtWeight)
        val edtHeight: EditText = findViewById(R.id.edtTxtHeight)


        btnCalculate.setOnClickListener {

            // BMI Calc
            val weightStr = edtWeight.text.toString()
            val heightStr = edtHeight.text.toString()

            if(weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val height: Float = heightStr.toFloat()
                val heightSquared: Float = height * height
                val weight: Float = weightStr.toFloat()
                val result: Float = weight / heightSquared

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Favor preencher todos os campos", Toast.LENGTH_LONG).show()
            }


        }
    }
}