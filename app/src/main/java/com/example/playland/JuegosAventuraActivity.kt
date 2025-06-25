package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JuegosAventuraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juegos_aventura)

        val btnJuego1 = findViewById<Button>(R.id.btnJuego1)
        val btnJuego2 = findViewById<Button>(R.id.btnJuego2)
        val btnJuego3 = findViewById<Button>(R.id.btnJuego3)
        val btnJuego4 = findViewById<Button>(R.id.btnJuego4)
        val btnVolver = findViewById<Button>(R.id.btnVolverCategorias)

        btnJuego1.setOnClickListener {
            abrirDetalle("Explorador Fantástico", "¡Únete a una emocionante expedición por tierras desconocidas! Explora vastos paisajes, descubre artefactos antiguos y enfrenta desafíos que pondrán a prueba tu valentía y estrategia.")
        }

        btnJuego2.setOnClickListener {
            abrirDetalle("Selva Misteriosa", "Embárcate en una aventura en lo más profundo de la selva, donde criaturas misteriosas y secretos ancestrales te esperan. Resuelve enigmas, supera peligros y desvela los secretos ocultos de la jungla.")
        }

        btnJuego3.setOnClickListener {
            abrirDetalle("Cueva del Tesoro", "Adéntrate en una cueva legendaria llena de tesoros perdidos y trampas mortales. Demuestra tu habilidad para superar obstáculos y recolectar riquezas invaluables en esta emocionante expedición subterránea.")
        }

        btnJuego4.setOnClickListener {
            abrirDetalle("Isla Perdida", "Descubre los misterios de una isla olvidada en medio del océano. Navega por aguas turbulentas, explora ruinas antiguas y desafía los peligros naturales para desentrañar los secretos que guarda este remoto paraíso.")
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
