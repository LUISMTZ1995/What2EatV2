package com.example.what2eatv2

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Comida(val comidaId: String? ="", val nombre: String? =""){
    constructor(): this("",""){}
}
