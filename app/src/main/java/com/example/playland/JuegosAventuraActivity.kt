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
        val btnEstadisticasJuego1 = findViewById<Button>(R.id.btnEstadisticasJuego1)
        val btnEstadisticasJuego2 = findViewById<Button>(R.id.btnEstadisticasJuego2)
        val btnEstadisticasJuego3 = findViewById<Button>(R.id.btnEstadisticasJuego3)
        val btnEstadisticasJuego4 = findViewById<Button>(R.id.btnEstadisticasJuego4)


        btnJuego1.setOnClickListener {
            abrirDetalle("Explorador Fantástico", "Descripción detallada del juego Explorador Fantástico.")

        }
        btnEstadisticasJuego1.setOnClickListener {
            abrirEstadisticas("Explorador Fantástico")
        }
        btnJuego2.setOnClickListener {
            abrirDetalle("Selva Misteriosa", "Descripción detallada del juego Selva Misteriosa.")
        }
        btnEstadisticasJuego2.setOnClickListener {
            abrirEstadisticas("Selva Misteriosa")
        }
        btnJuego3.setOnClickListener {
            abrirDetalle("Cueva del Tesoro", "Descripción detallada del juego Cueva del Tesoro.")
        }
        btnEstadisticasJuego3.setOnClickListener {
            abrirEstadisticas("Cueva del Tesoro")
        }
        btnJuego4.setOnClickListener {
            abrirDetalle("Isla Perdida", "Descripción detallada del juego Isla Perdida.")
        }
        btnEstadisticasJuego4.setOnClickListener {
            abrirEstadisticas("Isla Perdida")
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
