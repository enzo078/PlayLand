package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JuegosHabilidadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juegos_habilidad)

        val btnJuego1 = findViewById<Button>(R.id.btnJuego1)
        val btnJuego2 = findViewById<Button>(R.id.btnJuego2)
        val btnJuego3 = findViewById<Button>(R.id.btnJuego3)
        val btnJuego4 = findViewById<Button>(R.id.btnJuego4)
        val btnVolver = findViewById<Button>(R.id.btnVolverCategorias)
        val btnEstadisticasJuego1 = findViewById<Button>(R.id.btnEstadisticasJuego1)
        val btnEstadisticasJuego2 = findViewById<Button>(R.id.btnEstadisticasJuego2)
        val btnEstadisticasJuego3 = findViewById<Button>(R.id.btnEstadisticasJuego3)
        val btnEstadisticasJuego4 = findViewById<Button>(R.id.btnEstadisticasJuego4)

        btnJuego1.setOnClickListener {
            abrirDetalle("Agilidad Mental", "Poné a prueba tu rapidez para resolver problemas lógicos en pocos segundos.")
        }
        btnEstadisticasJuego1.setOnClickListener {
            abrirEstadisticas("Agilidad Mental")
        }

        btnJuego2.setOnClickListener {
            abrirDetalle("Reflejos Rápidos", "Reaccioná lo más rápido posible ante desafíos visuales y auditivos.")
        }
        btnEstadisticasJuego2.setOnClickListener {
            abrirEstadisticas("Reflejos Rápidos")
        }

        btnJuego3.setOnClickListener {
            abrirDetalle("Pregunta2", "Ponete a prueba con otras personas en este juego de preguntas para saber quién sabe más!.")
        }
        btnEstadisticasJuego3.setOnClickListener {
            abrirEstadisticas("Pregunta2")
        }

        btnJuego4.setOnClickListener {
            abrirDetalle("Memorama", "Entrená tu memoria encontrando los pares de cartas iguales.")
        }
        btnEstadisticasJuego4.setOnClickListener {
            abrirEstadisticas("Memorama")
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
