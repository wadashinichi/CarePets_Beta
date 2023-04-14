package com.example.carepets_beta.petlist

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.carepets_beta.R
import com.example.carepets_beta.database.PetRepository
import com.example.carepets_beta.databinding.ActivityPetListBinding

class PetListActivity : AppCompatActivity() {

    lateinit var binding: ActivityPetListBinding
    lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetRepository(application)

    }


}