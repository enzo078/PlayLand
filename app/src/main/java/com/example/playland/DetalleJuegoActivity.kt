package com.example.playland

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleJuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_juego)

        val tvNombre = findViewById<TextView>(R.id.tvNombreJuego)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcionJuego)
        val btnVolver = findViewById<Button>(R.id.btnVolverLista)

        // Obtener datos del intent
        val nombre = intent.getStringExtra("nombreJuego") ?: "Juego"
        val descripcion = intent.getStringExtra("descripcionJuego") ?: "Sin descripción disponible."

        tvNombre.text = nombre
        tvDescripcion.text = descripcion

        btnVolver.setOnClickListener {
            finish() //
        }
    }
}
