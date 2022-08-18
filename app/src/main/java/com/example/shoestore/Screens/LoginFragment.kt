package com.example.shoestore.Screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment(),View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setMenuVisibility(false)

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            loginBtn.setOnClickListener (this@LoginFragment)
            signupBtn.setOnClickListener (this@LoginFragment)
        }
    }

    override fun onClick(v: View?) {
        val preferences = activity?.getSharedPreferences("First", Context.MODE_PRIVATE)
        val first = preferences?.getBoolean("isFirst", true)

        //navigate
        if (first!!) {
            val editPreferences =
                activity?.getSharedPreferences("First", Context.MODE_PRIVATE)?.edit()
            editPreferences?.putBoolean("isFirst", false)?.apply()
            //To Onboarding Screen
            view?.findNavController()
                ?.navigate(R.id.action_loginFragment_to_welcomeOnboardingFragment)
        } else {
            view?.findNavController()
                ?.navigate(R.id.action_loginFragment_to_shoeListingFragment)
        }
    }
}