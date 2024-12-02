package com.example.kotlinbasics

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class GreetingActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var greetingButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var  openCalculator: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greeting)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        nameEditText = findViewById(R.id.nameEditText)
        greetingButton = findViewById(R.id.greetButton)
        resultTextView = findViewById(R.id.resultTextView)
        openCalculator = findViewById(R.id.openCalculatorButton)

        greetingButton.setOnClickListener() {
            val name = nameEditText.text
            if (name.isNotEmpty()) {
                val greetingText = when {
                    name.length <= 3 -> "Szia $name! De rövid neved van!"
                    name.length >= 10 -> "Szia $name! De hosszú neved van!"
                    else -> "Hello $name"
                }
                resultTextView.text = greetingText

                nameEditText.text.clear()
            }
            else {
                Toast.makeText(this, "Adj meg nevet", Toast.LENGTH_SHORT).show()
            }
        }

        openCalculator.setOnClickListener() {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}