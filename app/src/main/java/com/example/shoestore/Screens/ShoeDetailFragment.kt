package com.example.shoestore.Screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.models.ShoeViewModel
import com.example.shoestore.databinding.FragmentShoeDetailFragmentBinding


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailFragmentBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            //SAVE
            saveBtn.setOnClickListener {
                val shoeViewModel:ShoeViewModel by activityViewModels()
                //2-Way dataBinding
                shoe = shoeViewModel
                lifecycleOwner = this@ShoeDetailFragment
                shoeViewModel.insert(binding.shoe as ShoeViewModel) //ISSUE HERE i think
//                shoeViewModel.add(Shoe(
//                    etName.text.toString(),
//                    etCompany.text.toString(),
//                    etSize.text.toString(),
//                    etDesciption.text.toString(),
//                ))

                navigate()
            }

            //CANCEL
            cancelBtn.setOnClickListener {
                navigate()
            }
        }
    }
    private fun navigate(){
        val action = ShoeDetailFragmentDirections
            .actionShoeDetailFragmnetToShoeListingFragment()

        findNavController()
            .navigate(action)
    }

}