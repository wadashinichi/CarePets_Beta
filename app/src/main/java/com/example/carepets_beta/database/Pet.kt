package com.example.carepets_beta.database

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pet_table")
data class Pet(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "pet_name")
    var name: String = "",

    @ColumnInfo(name = "pet_img")
    var img: Int = 0,

    @ColumnInfo(name = "pet_birth")
    var birth: String = "",

    @ColumnInfo(name = "pet_species")
    var species: String = ""
)