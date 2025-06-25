package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class InicioSimulacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_simulacion)

        val etNombre = findViewById<EditText>(R.id.etNombreJugador)
        val rgDificultad = findViewById<RadioGroup>(R.id.rgDificultad)
        val btnJugar = findViewById<Button>(R.id.btnIniciarJuego)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val juego = intent.getStringExtra("juego") ?: ""

        btnJugar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val dificultad = when (rgDificultad.checkedRadioButtonId) {
                R.id.rbNovato -> "Novato"
                R.id.rbAmateur -> "Amateur"
                R.id.rbProfesional -> "Profesional"
                else -> ""
            }

            if (nombre.isNotBlank() && dificultad.isNotBlank()) {
                val intent = Intent(this, JuegoEnCursoActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("dificultad", dificultad)
                intent.putExtra("juego", juego)
                startActivity(intent)
            }
        }
        btnVolver.setOnClickListener {
            finish()
        }

    }
}
