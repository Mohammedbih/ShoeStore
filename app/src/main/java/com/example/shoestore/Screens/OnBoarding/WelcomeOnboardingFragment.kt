package com.example.shoestore.Screens.OnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomeOnboardingBinding


class WelcomeOnboardingFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeOnboardingBinding.inflate(inflater, container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        activity?.actionBar?.hide()

        binding.instructionsBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeOnboardingFragment_to_instructionsOnboardingFragment)
        }
    }
}