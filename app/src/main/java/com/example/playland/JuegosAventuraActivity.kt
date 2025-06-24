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
            abrirDetalle("Explorador Fantástico", "Descripción detallada del juego Explorador Fantástico.")
        }
        btnJuego2.setOnClickListener {
            abrirDetalle("Selva Misteriosa", "Descripción detallada del juego Selva Misteriosa.")
        }
        btnJuego3.setOnClickListener {
            abrirDetalle("Cueva del Tesoro", "Descripción detallada del juego Cueva del Tesoro.")
        }
        btnJuego4.setOnClickListener {
            abrirDetalle("Isla Perdida", "Descripción detallada del juego Isla Perdida.")
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
}
