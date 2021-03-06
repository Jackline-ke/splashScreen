package com.example.splashscreen

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.splashscreen.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        val view = binding.root
        auth = FirebaseAuth.getInstance()

        binding.button5.setOnClickListener {

            //view are blank
            val email = binding.editTextTextEmailAddress3.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val confirmPassword = binding.confirmPassword.text.toString()

            if(TextUtils.isEmpty(email)){
                binding.editTextTextEmailAddress3.error = "Required"
            }else if (TextUtils.isEmpty(password)){
                binding.editTextTextPassword.error = "Required"
            }else if (TextUtils.isEmpty(confirmPassword)){
                binding.confirmPassword.error = "Required"
            }else if (!password.equals(confirmPassword)){
                binding.confirmPassword.error = "Not Matching"
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                if (task.isSuccessful){
                    Toast.makeText(requireContext(), "Account created successfully", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(requireContext(), "Authentication failed", Toast.LENGTH_SHORT).show()

                }
            }
        }
        return view

    }
}