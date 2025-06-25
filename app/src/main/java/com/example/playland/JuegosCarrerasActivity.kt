package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JuegosCarrerasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juegos_carreras)

        val btnJuego1 = findViewById<Button>(R.id.btnJuego1)
        val btnJuego2 = findViewById<Button>(R.id.btnJuego2)
        val btnJuego3 = findViewById<Button>(R.id.btnJuego3)
        val btnJuego4 = findViewById<Button>(R.id.btnJuego4)

        val btnEstadisticasJuego1 = findViewById<Button>(R.id.btnEstadisticasJuego1)
        val btnEstadisticasJuego2 = findViewById<Button>(R.id.btnEstadisticasJuego2)
        val btnEstadisticasJuego3 = findViewById<Button>(R.id.btnEstadisticasJuego3)
        val btnEstadisticasJuego4 = findViewById<Button>(R.id.btnEstadisticasJuego4)

        val btnVolver = findViewById<Button>(R.id.btnVolverCategorias)

        btnJuego1.setOnClickListener {
            abrirDetalle("Velocidad Extrema", "Participá en carreras ilegales por la ciudad esquivando obstáculos a toda velocidad.")
        }
        btnEstadisticasJuego1.setOnClickListener {
            abrirEstadisticas("Velocidad Extrema")
        }

        btnJuego2.setOnClickListener {
            abrirDetalle("Fórmula PlayLand", "Convertite en el campeón mundial en circuitos de Fórmula 1 con autos ultra rápidos.")
        }
        btnEstadisticasJuego2.setOnClickListener {
            abrirEstadisticas("Fórmula PlayLand")
        }

        btnJuego3.setOnClickListener {
            abrirDetalle("Moto GP", "Competí en las pistas más desafiantes del mundo con motos de alta cilindrada.")
        }
        btnEstadisticasJuego3.setOnClickListener {
            abrirEstadisticas("Moto GP")
        }

        btnJuego4.setOnClickListener {
            abrirDetalle("Derrapes Urbanos", "Dominá las calles con tus habilidades de drifting en ambientes urbanos.")
        }
        btnEstadisticasJuego4.setOnClickListener {
            abrirEstadisticas("Derrapes Urbanos")
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this, CategoriaActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun abrirDetalle(nombre: String, descripcion: String) {
        val intent = Intent(this, DetalleJuegoActivity::class.java)
        intent.putExtra("nombreJuego", nombre)
        intent.putExtra("descripcionJuego", descripcion)
        startActivity(intent)
    }
    private fun abrirEstadisticas(nombreJuego: String) {
        val intent = Intent(this, EstadisticasActivity::class.java)
        intent.putExtra("juego", nombreJuego) // Este nombre debe coincidir con el usado en EstadisticasStorage
        startActivity(intent)
    }
}
