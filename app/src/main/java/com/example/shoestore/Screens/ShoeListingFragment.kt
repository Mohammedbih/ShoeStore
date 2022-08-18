package com.example.shoestore.Screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.databinding.ShoeItemBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.models.ShoeViewModel


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shoeViewModel: ShoeViewModel by activityViewModels()
        shoeViewModel.shoes.observe(requireActivity()) {
            val itr = it.listIterator()
            while (itr.hasNext())
                draw(itr.next())
        }

        binding.addFloatingBtn.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_shoeListingFragment_to_shoeDetailFragmnet)
        }

    }

    @SuppressLint("InflateParams")
    private fun draw(shoe: Shoe) {
        val binding: ShoeItemBinding = ShoeItemBinding.inflate(layoutInflater)

        binding.apply {
            tvName.text = shoe.name
            tvCompany.text = shoe.company
            tvSize.text = shoe.size
            tvDescriptions.text = shoe.description
        }

        this.binding.linearLayout.addView(binding.root)
    }
}



