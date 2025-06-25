package com.example.playland

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object EstadisticasStorage {
    private const val PREFS_NAME = "estadisticas"
    private const val KEY_JUGADAS = "jugadas"

    fun guardarJugada(context: Context, nombre: String, nivel: Int, puntaje: Int, complejidad: String, juego: String) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val jugadasStr = prefs.getString(KEY_JUGADAS, "[]")
        val jugadas = JSONArray(jugadasStr)

        val jugada = JSONObject().apply {
            put("nombre", nombre)
            put("nivel", nivel)
            put("puntaje", puntaje)
            put("complejidad", complejidad)
            put("juego", juego)
        }

        val nuevaLista = JSONArray().apply {
            put(jugada)
            var contador = 1
            for (i in 0 until jugadas.length()) {
                val existente = jugadas.getJSONObject(i)
                if (existente.getString("juego") == juego) {
                    if (contador < 10) {
                        put(existente)
                        contador++
                    }
                } else {
                    put(existente)
                }
            }
        }

        prefs.edit().putString(KEY_JUGADAS, nuevaLista.toString()).apply()
    }

    fun obtenerJugadasPorJuego(context: Context, juego: String): List<JSONObject> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val jugadasStr = prefs.getString(KEY_JUGADAS, "[]")
        val jugadas = JSONArray(jugadasStr)
        val lista = mutableListOf<JSONObject>()
        for (i in 0 until jugadas.length()) {
            val jugada = jugadas.getJSONObject(i)
            if (jugada.getString("juego") == juego) {
                lista.add(jugada)
            }
        }
        return lista
    }
}