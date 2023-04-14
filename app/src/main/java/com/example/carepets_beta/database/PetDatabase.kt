package com.example.carepets_beta.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pet::class], version = 1)
abstract class PetDatabase : RoomDatabase() {

    abstract fun petDao(): PetDao

    companion object {

        @Volatile
        private var INSTANCE: PetDatabase? = null

        fun getInstance(context: Context): PetDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PetDatabase::class.java,
                        "pet_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
                return instance
            }
        }
    }
}