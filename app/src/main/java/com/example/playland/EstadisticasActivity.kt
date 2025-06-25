package com.example.playland

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class EstadisticasActivity : AppCompatActivity() {

    private lateinit var listaEstadisticas: ListView
    private lateinit var btnVolverJuego: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        listaEstadisticas = findViewById(R.id.listaEstadisticas)
        btnVolverJuego = findViewById(R.id.btnVolverJuego)

        // Recibe el identificador del juego (nombre o id) por Intent
        val nombreJuego = intent.getStringExtra("juego") ?: ""

        // Obtiene solo las jugadas de ese juego
        val jugadas = EstadisticasStorage.obtenerJugadasPorJuego(this, nombreJuego)
        val listaFormateada = jugadas.map {
            val nombre = it.getString("nombre")
            val nivel = it.getInt("nivel")
            val puntaje = it.getInt("puntaje")
            val complejidad = it.getString("complejidad")
            "$nombre - $complejidad - Nivel $nivel - $puntaje pts"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFormateada)
        listaEstadisticas.adapter = adapter

        btnVolverJuego.setOnClickListener {
            finish()
        }
    }
}