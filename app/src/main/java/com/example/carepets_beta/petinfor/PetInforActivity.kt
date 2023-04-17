package com.example.carepets_beta.petinfor

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.icu.util.Calendar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.example.carepets_beta.database.Pet
import com.example.carepets_beta.database.PetRepository
import com.example.carepets_beta.databinding.ActivityPetInforBinding
import com.example.carepets_beta.petlist.PetListActivity
import java.io.ByteArrayOutputStream

class PetInforActivity : AppCompatActivity() {
    lateinit var binding: ActivityPetInforBinding
    lateinit var res: PetRepository
    lateinit var uri: Uri
    lateinit var bmp: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetInforBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetRepository(application)

        binding.btnPickImg.setOnClickListener{
            pickImg()
        }
        var name: String = binding.editName.toString()
        var species: String = binding.editSpecies.toString()
        var birth: String = ""
        binding.editBirth.setOnClickListener {view: View ->
            birth = takeDate(view)
        }
        binding.btnSubmit.setOnClickListener {
            var bmpDrawable: BitmapDrawable = binding.imgPet.drawable as BitmapDrawable
            bmp = bmpDrawable.bitmap
            var byte: ByteArrayOutputStream = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.PNG, 100, byte)
            var imgByte = byte.toByteArray()
            var bitmap: Bitmap = byte.buffered()
            var pet: Pet = Pet(null, name, imgByte, birth, species)
            res.insert(pet)
            Toast.makeText(this,"Add a new pet", Toast.LENGTH_SHORT ).show()
            Thread.sleep(2000)
            reDirect()
        }
    }
    private fun takeDate(view: View): String {
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            binding.editBirth.text = "$day/${month+1}/$year"
        }, year, month, day)
            .show()
        return "$day/${month+1}/$year"
    }
    private fun pickImg() {
        var i: Intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(i, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_OK && data != null) {
            var selectedImgUri: Uri? = data.data
            binding.imgPet.setImageURI(selectedImgUri)
//            if (selectedImgUri != null) {
//                uri = selectedImgUri
//                var inputStream: InputStream? = contentResolver.openInputStream(uri)
//                bmp = BitmapFactory.decodeStream(inputStream)
//            }
        }
    }
    fun reDirect() {
        var i: Intent = Intent()
        i.setClass(this, PetListActivity::class.java)
        startActivity(i)
    }
}