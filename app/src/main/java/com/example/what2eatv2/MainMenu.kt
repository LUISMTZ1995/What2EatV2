package com.example.what2eatv2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.main_menu.*

class MainMenu : AppCompatActivity() {
    lateinit var platillo: EditText
    lateinit var lista: ListView
    lateinit var agregar: Button
    private lateinit var database: DatabaseReference
    lateinit var comidaList: MutableList<Comida>
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
        platillo = findViewById(R.id.agregar)
        lista = findViewById(R.id.lista)
        agregar = findViewById(R.id.agregar)
        listView = findViewById(R.id.lista)
        database = FirebaseDatabase.getInstance().reference
        //val database = FirebaseDatabase.getInstance()
        //val ref = database.getReference("Platillo")
        comidaList = mutableListOf()

        empesar.setOnClickListener {
            val siguiente = Intent(this, GameOn::class.java)
            startActivity(siguiente)
        }
        agregar.setOnClickListener{
            salvarPlatillo(comidaId = "", nombre = "")
        }
        database.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    comidaList.clear()
                    for(c in p0.children){
                        val comida = c.getValue(Comida::class.java)
                        comidaList.add(comida!!)
                    }
                    val adapter = ComidaAdapter(applicationContext, R.layout.comidas, comidaList)
                    listView.adapter = adapter
                }
            }

        })
    }

    private fun salvarPlatillo(comidaId: String, nombre: String) {


        val Platillo = platillo.text.toString().trim()

        if(Platillo.isEmpty()){
            platillo.error = "Por favor, agregar un platillo"
            return
        }

        val comida = Comida(comidaId, nombre)
        database.child("Platillo").child(comidaId).child(Platillo).setValue(comida).addOnCompleteListener{
            Toast.makeText(applicationContext, "Comida agregada", Toast.LENGTH_LONG)
        }

    }
}