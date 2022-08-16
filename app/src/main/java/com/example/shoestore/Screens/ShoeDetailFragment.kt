package com.example.shoestore.Screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.shoestore.Model.Shoe
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailFragmentBinding


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailFragmentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            //SAVE
            saveBtn.setOnClickListener {

                val action = ShoeDetailFragmentDirections
                    .actionShoeDetailFragmnetToShoeListingFragment(true,
                        etName.text.toString(),
                        etCompane.text.toString(),
                        etDesciption.text.toString(),
                        etSize.text.toString()
                    )

                view.findNavController()
                    .navigate(action)
            }

            //CANCEL
            cancelBtn.setOnClickListener {

                val action = ShoeDetailFragmentDirections
                    .actionShoeDetailFragmnetToShoeListingFragment(false,
                        "",
                        "",
                        "",
                        "44f"
                        )

                view.findNavController()
                    .navigate(action)
            }
        }
    }

}