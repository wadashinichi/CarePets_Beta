package com.example.carepets_beta.maincontent.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carepets_beta.database.Pet
import com.example.carepets_beta.database.PetRepository
import com.example.carepets_beta.databinding.FragmentHomeBinding
//import com.example.carepets_beta.maincontent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var res: PetRepository

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        /*recive id from direct
                take data of its id*/
        res = activity?.let { PetRepository(it.application) }!!
        var pet: Pet = res.getById(idVar)
        /*convert bitmap
                to image*/

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}