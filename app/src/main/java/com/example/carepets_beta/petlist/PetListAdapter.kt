package com.example.carepets_beta.petlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets_beta.R
import com.example.carepets_beta.database.Pet
import com.example.carepets_beta.databinding.ActivityPetListBinding

class PetListAdapter(var plist: List<Pet>) : RecyclerView.Adapter<PetListAdapter.ViewHolder>() {

    lateinit var binding: ActivityPetListBinding
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img: ImageView = itemView.findViewById(R.id.pet_name)
        val name: TextView = itemView.findViewById(R.id.pet_name)
        val species: TextView = itemView.findViewById(R.id.pet_species)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet_list_line, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return plist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = plist[position]
        holder.img.setImageResource(item.img)
        holder.name.text = item.name
        holder.species.text = item.species
    }
}