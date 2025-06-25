package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnVolver = findViewById<Button>(R.id.btnVolverDetalle)

        val nombre = intent.getStringExtra("nombre") ?: ""
        val dificultad = intent.getStringExtra("dificultad") ?: ""
        val nivel = intent.getIntExtra("nivel", 1)
        val puntaje = intent.getIntExtra("puntaje", 0)
        val juego = intent.getStringExtra("juego") ?: ""

        EstadisticasStorage.guardarJugada(this, nombre, nivel, puntaje, dificultad, juego)

        tvResultado.text = "$nombre logró el nivel $nivel con $puntaje puntos ($dificultad)"

        btnVolver.setOnClickListener {
            val intent = Intent(this, DetalleJuegoActivity::class.java)
            intent.putExtra("nombreJuego", juego)
            intent.putExtra("descripcionJuego", "Descripción del juego")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }

}
