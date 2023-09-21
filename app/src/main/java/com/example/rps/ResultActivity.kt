package com.example.rps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvUserChoice: TextView
    private lateinit var tvComputerChoice: TextView
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvUserChoice = findViewById(R.id.tvUserChoice)
        tvComputerChoice = findViewById(R.id.tvComputerChoice)
        tvResult = findViewById(R.id.tvResult)

        val userChoice = intent.getStringExtra("userChoice")
        val computerChoice = intent.getStringExtra("computerChoice")

        tvUserChoice.text = "Ваш выбор: $userChoice"
        tvComputerChoice.text = "Выбор компьютера: $computerChoice"

        val result = determineWinner(userChoice, computerChoice)
        tvResult.text = result
    }

    private fun determineWinner(userChoice: String?, computerChoice: String?): String {
        if (userChoice == computerChoice) {
            return "Ничья"
        }
        return when {
            (userChoice == "Камень" && computerChoice == "Ножницы") ||
                    (userChoice == "Ножницы" && computerChoice == "Бумага") ||
                    (userChoice == "Бумага" && computerChoice == "Камень") -> "Вы победили!"
            else -> "Вы проиграли!"
        }
    }
}


