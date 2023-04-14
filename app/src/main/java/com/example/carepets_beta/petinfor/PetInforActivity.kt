package com.example.carepets_beta.petinfor

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.carepets_beta.R
import com.example.carepets_beta.database.PetRepository
import com.example.carepets_beta.databinding.ActivityPetInforBinding

class PetInforActivity : AppCompatActivity() {
    lateinit var binding: ActivityPetInforBinding
    lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetInforBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetRepository(application)
        var name: String = binding.editName.toString()
        var species: String = binding.editSpecies.toString()
    }
    private fun takeDate(view: View) {
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            binding.editBirth.text = "$day/${month+1}/$year"
        }, year, month, day)
            .show()
    }
}