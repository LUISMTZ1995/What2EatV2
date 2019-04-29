package com.example.what2eatv2

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.game_on.*
import java.util.*

class GameOn : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    val lista = arrayListOf(database)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_on)
        val elegidoButton: Button = findViewById(R.id.play)
        val busquedaButton: Button = findViewById(R.id.busqueda)
        val resultadoPlatillo: TextView = findViewById(R.id.elegido)
        elegidoButton.setOnClickListener{
            val aleatoreo = Random()
            val programaAle = aleatoreo.nextInt(lista.count())
            resultadoPlatillo.text = lista[programaAle].toString()
        }
        busquedaButton.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.mx/maps/search/" + resultadoPlatillo.text))
            //Al final del URL quiero poner la palabra que se muestra en el textview
            startActivity(i)
        }
    }
}