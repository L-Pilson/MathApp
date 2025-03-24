package com.example.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get reference to our calculate button
        val calculateButton = findViewById<Button>(R.id.buttonCalculate)

        // Set up the click listener
        calculateButton.setOnClickListener {
            // Get the input values when the button is clicked
            val num1 = findViewById<EditText>(R.id.editTextFirstNumber).text.toString()
            val num2 = findViewById<EditText>(R.id.editTextSecondNumber).text.toString()
            val resultView = findViewById<TextView>(R.id.textViewResult)

            // Check if inputs are not empty
            if (num1.isEmpty() || num2.isEmpty()) {
                resultView.text = "Enter both numbers"
                return@setOnClickListener
            }

            try {
                // Convert to numbers
                val firstNum = num1.toDouble()
                val secondNum = num2.toDouble()

                // Check which operation is selected
                val isAddition = findViewById<RadioButton>(R.id.radioButtonAdd).isChecked

                // Calculate result
                val result = if (isAddition) {
                    firstNum + secondNum
                } else {
                    firstNum - secondNum
                }

                // Show result
                resultView.text = result.toString()

            } catch (e: Exception) {
                resultView.text = "Invalid input"
            }
        }
    }
}