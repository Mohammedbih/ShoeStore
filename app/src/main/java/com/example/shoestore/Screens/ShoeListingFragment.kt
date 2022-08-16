package com.example.shoestore.Screens

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.Model.Shoe
import com.example.shoestore.Model.ShoeViewModel
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListingBinding
import java.lang.Exception
import javax.security.auth.login.LoginException
import androidx.navigation.fragment.navArgs as navArgs


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding

    private var flag = false
    private var name = ""
    private var company = ""
    private var description = ""
    private var size = "44f"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListingBinding.inflate(inflater, container, false)

        flag = ShoeListingFragmentArgs.fromBundle(requireArguments()).flag
        name = ShoeListingFragmentArgs.fromBundle(requireArguments()).name
        company = ShoeListingFragmentArgs.fromBundle(requireArguments()).company
        description = ShoeListingFragmentArgs.fromBundle(requireArguments()).description
        size = ShoeListingFragmentArgs.fromBundle(requireArguments()).size



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]


        if (flag) {
            try {
                viewModel.add(
                    Shoe(
                        name,
                        company,
                        size,
                        description
                    )
                )
            } catch (e: Exception) {
                Log.i("e", e.message.toString())
            }
        }


//        if (flag) {
//            viewModel.add(flag)
//        }

        viewModel.shoes.observe(requireActivity()) {
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
        val v = layoutInflater.inflate(R.layout.shoe_item, null)

        v.findViewById<TextView>(R.id.tv_name).text = shoe.name
        v.findViewById<TextView>(R.id.tv_company).text = shoe.company
        v.findViewById<TextView>(R.id.tv_size).text = shoe.size
        v.findViewById<TextView>(R.id.tv_descriptions).text = shoe.description

        binding.linearLayout.addView(v)
    }


}



