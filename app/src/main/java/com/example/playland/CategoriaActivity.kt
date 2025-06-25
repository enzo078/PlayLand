package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoriaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)

        val btnAventura = findViewById<Button>(R.id.btnAventura)
        val btnCarreras = findViewById<Button>(R.id.btnCarreras)
        val btnPuzzle = findViewById<Button>(R.id.btnPuzzle)
        val btnHabilidad = findViewById<Button>(R.id.btnHabilidad)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnAventura.setOnClickListener {
            startActivity(Intent(this, JuegosAventuraActivity::class.java))
        }

        btnCarreras.setOnClickListener {
            startActivity(Intent(this, JuegosCarrerasActivity::class.java))
        }

        btnPuzzle.setOnClickListener {
            startActivity(Intent(this, JuegosPuzzleActivity::class.java))
        }

        btnHabilidad.setOnClickListener {
            startActivity(Intent(this, JuegosHabilidadActivity::class.java))
        }

        btnVolver.setOnClickListener {
            finish() //
        }
    }
}
