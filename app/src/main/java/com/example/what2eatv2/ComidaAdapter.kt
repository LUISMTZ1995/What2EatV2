package com.example.what2eatv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ComidaAdapter(val mCtx: Context, val layoutResId: Int, val comidaList: List<Comida>)
    : ArrayAdapter<Comida>(mCtx, layoutResId, comidaList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx);
        val view: View = layoutInflater.inflate(layoutResId, null)
        val textViewName = view.findViewById<TextView>(R.id.textViewName);
        val comidita = comidaList[position]
        textViewName.text = comidita.nombre
        return view;
    }
}