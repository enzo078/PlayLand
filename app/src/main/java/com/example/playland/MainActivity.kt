package com.example.playland

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrCategorias = findViewById<Button>(R.id.btnIrCategorias)
        btnIrCategorias.setOnClickListener {
            val intent = Intent(this, CategoriaActivity::class.java)
            startActivity(intent)
        }
    }
}