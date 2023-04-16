package com.example.carepets_beta.database

import android.app.Application

class PetRepository(var application: Application) {
    private lateinit var db: PetDatabase
    init {
        db = PetDatabase.getInstance(application)
    }
    fun insert(name: String, img: Int, birth: String, species: String) {
        db.petDao().insertPet(name, img, birth, species)
    }
    fun getCount(): Int = db.petDao().getPetCount()

    fun getAll(): List<Pet> = db.petDao().getAll()
}