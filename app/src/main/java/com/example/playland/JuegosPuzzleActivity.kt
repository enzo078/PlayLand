package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JuegosPuzzleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juegos_puzzle)

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
            abrirDetalle("Bloques Lógicos", "Encajá piezas con distintas formas en el espacio correcto antes de que se acabe el tiempo.")
        }
        btnEstadisticasJuego1.setOnClickListener {
            abrirEstadisticas("Bloques Lógicos")
        }

        btnJuego2.setOnClickListener {
            abrirDetalle("Sudoku Master", "Demostrá tu habilidad con los números completando los tableros más difíciles.")
        }
        btnEstadisticasJuego2.setOnClickListener {
            abrirEstadisticas("Sudoku Master")
        }

        btnJuego3.setOnClickListener {
            abrirDetalle("Conecta 3", "Alineá 3 o más figuras iguales para sumar puntos y superar niveles.")
        }
        btnEstadisticasJuego3.setOnClickListener {
            abrirEstadisticas("Conecta 3")
        }

        btnJuego4.setOnClickListener {
            abrirDetalle("Rompecabezas 3D", "Armá estructuras tridimensionales a partir de piezas dispersas.")
        }
        btnEstadisticasJuego4.setOnClickListener {
            abrirEstadisticas("Rompecabezas 3D")
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
