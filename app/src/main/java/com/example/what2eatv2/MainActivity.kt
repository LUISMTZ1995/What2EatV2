package com.example.what2eatv2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val starButton: Button = findViewById(R.id.button)
        button.setOnClickListener{
            val siguiente = Intent(this,MainMenu::class.java)
            startActivity(siguiente)
        }
    }
}
