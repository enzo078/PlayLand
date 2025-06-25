package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class JuegoEnCursoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_en_curso)

        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)

        val nombre = intent.getStringExtra("nombre") ?: ""
        val dificultad = intent.getStringExtra("dificultad") ?: ""
        val juego = intent.getStringExtra("juego") ?: ""

        btnFinalizar.setOnClickListener {
            val (nivel, puntaje) = generarResultado(dificultad)
            val intent = Intent(this, GameOverActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("dificultad", dificultad)
            intent.putExtra("nivel", nivel)
            intent.putExtra("puntaje", puntaje)
            intent.putExtra("juego", juego)
            startActivity(intent)
            finish()
        }
    }

    private fun generarResultado(dificultad: String): Pair<Int, Int> {
        return when (dificultad) {
            "Novato" -> (1..3).random() to (100..500).random()
            "Amateur" -> (4..7).random() to (600..1000).random()
            "Profesional" -> (8..10).random() to (1100..2000).random()
            else -> 1 to 100
        }
    }
}
