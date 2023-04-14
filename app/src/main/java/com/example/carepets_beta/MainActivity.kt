package com.example.carepets_beta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carepets_beta.database.PetRepository
import com.example.carepets_beta.databinding.ActivityMainBinding
import com.example.carepets_beta.petlist.PetListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread.sleep(5000)

        var i: Intent = Intent()

        res = PetRepository(application)
        var count: Int = 0
        count = countPet()
        if (count == 0) {
            i.setClass(this, PetListActivity::class.java)
            startActivity(i)
        } else {
//            i.setClass(this, PetListActivity::class.java)
        }

    }

    fun countPet(): Int = res.getCount()
}