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

        btnJuego1.setOnClickListener {
            abrirDetalle("Agilidad Mental", "Poné a prueba tu rapidez para resolver problemas lógicos en pocos segundos.")
        }

        btnJuego2.setOnClickListener {
            abrirDetalle("Reflejos Rápidos", "Reaccioná lo más rápido posible ante desafíos visuales y auditivos.")
        }

        btnJuego3.setOnClickListener {
            abrirDetalle("Pregunta2", "Ponete a prueba con otras personas en este juego de preguntas para saber quién sabe más!.")
        }

        btnJuego4.setOnClickListener {
            abrirDetalle("Memorama", "Entrená tu memoria encontrando los pares de cartas iguales.")
        }

        btnVolver.setOnClickListener {
            finish()
        }

    }

    private fun abrirDetalle(nombre: String, descripcion: String) {
        val intent = Intent(this, DetalleJuegoActivity::class.java)
        intent.putExtra("nombreJuego", nombre)
        intent.putExtra("descripcionJuego", descripcion)
        startActivity(intent)
    }

}
