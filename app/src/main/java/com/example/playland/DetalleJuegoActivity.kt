package com.example.playland

import android.content.Intent
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
        val btnEstadisticas = findViewById<Button>(R.id.btnVerEstadisticas)
        val btnJugar = findViewById<Button>(R.id.btnJugar)

        val nombre = intent.getStringExtra("nombreJuego") ?: "Juego"
        val descripcion = intent.getStringExtra("descripcionJuego") ?: "Sin descripción disponible."

        tvNombre.text = nombre
        tvDescripcion.text = descripcion

        btnEstadisticas.setOnClickListener {
            val intent = Intent(this, EstadisticasActivity::class.java)
            intent.putExtra("juego", nombre) // enviamos el nombre del juego
            startActivity(intent)
        }

        btnJugar.setOnClickListener {
            val intent = Intent(this, InicioSimulacionActivity::class.java)
            intent.putExtra("juego", nombre)
            startActivity(intent)
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}
