package com.example.rps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnRock: View
    private lateinit var btnScissors: View
    private lateinit var btnPaper: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRock = findViewById(R.id.btnRock)
        btnScissors = findViewById(R.id.btnScissors)
        btnPaper = findViewById(R.id.btnPaper)
    }

    fun onChoiceClick(view: View) {
        val userChoice = when (view.id) {
            R.id.btnRock -> "Камень"
            R.id.btnScissors -> "Ножницы"
            R.id.btnPaper -> "Бумага"
            else -> ""
        }

        val computerChoice = listOf("Камень", "Ножницы", "Бумага").random()

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("userChoice", userChoice)
        intent.putExtra("computerChoice", computerChoice)
        startActivity(intent)
    }
}


