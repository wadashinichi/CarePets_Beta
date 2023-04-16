package com.example.carepets_beta.petlist

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.carepets_beta.R
import com.example.carepets_beta.database.Pet
import com.example.carepets_beta.database.PetRepository
import com.example.carepets_beta.databinding.ActivityPetListBinding
import com.example.carepets_beta.petinfor.PetInforActivity

class PetListActivity : AppCompatActivity() {

    lateinit var binding: ActivityPetListBinding
    lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetRepository(application)
        displayList(this)

        binding.btnAdd.setOnClickListener {
            var i: Intent = Intent()
            i.setClass(this, PetInforActivity::class.java)
            startActivity(i)
        }
    }
    fun displayList(context: Context) {
        val pList: List<Pet> = res.getAll()
        val adapter = PetListAdapter(pList)
        binding.rvPetList.adapter = adapter
        binding.rvPetList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


}