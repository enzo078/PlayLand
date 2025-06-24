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

        btnJuego1.setOnClickListener {
            abrirDetalle("Bloques Lógicos", "Encajá piezas con distintas formas en el espacio correcto antes de que se acabe el tiempo.")
        }

        btnJuego2.setOnClickListener {
            abrirDetalle("Sudoku Master", "Demostrá tu habilidad con los números completando los tableros más difíciles.")
        }

        btnJuego3.setOnClickListener {
            abrirDetalle("Conecta 3", "Alineá 3 o más figuras iguales para sumar puntos y superar niveles.")
        }

        btnJuego4.setOnClickListener {
            abrirDetalle("Rompecabezas 3D", "Armá estructuras tridimensionales a partir de piezas dispersas.")
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
