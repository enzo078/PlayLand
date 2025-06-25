package com.example.playland

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class EstadisticasActivity : AppCompatActivity() {

    private lateinit var listaEstadisticas: ListView
    private lateinit var btnVolverJuego: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        listaEstadisticas = findViewById(R.id.listaEstadisticas)
        btnVolverJuego = findViewById(R.id.btnVolverJuego)

        val nombreJuego = intent.getStringExtra("juego") ?: ""

        val jugadas = EstadisticasStorage.obtenerJugadasPorJuego(this, nombreJuego)
            .sortedByDescending { it.getInt("puntaje") }
            .take(10) // máximo 10

        val listaFormateada: List<String> = if (jugadas.isEmpty()) {
            listOf("Aún no hay estadísticas para este juego.")
        } else {
            jugadas.map { formatearJugada(it) }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFormateada)
        listaEstadisticas.adapter = adapter

        btnVolverJuego.setOnClickListener {
            finish()
        }
    }

    private fun formatearJugada(jugada: JSONObject): String {
        val nombre = jugada.getString("nombre")
        val nivel = jugada.getInt("nivel")
        val puntaje = jugada.getInt("puntaje")
        val complejidad = jugada.getString("complejidad")
        return "$nombre - $complejidad - Nivel $nivel - $puntaje pts"
    }
}
