package com.example.groceryplus.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.groceryplus.R
import com.example.groceryplus.databinding.FragmentLoginBinding
import com.example.groceryplus.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(
            layoutInflater,
            container,
            false
        )
        val viewPager = activity?.findViewById<ViewPager2>(R.id.login_register_viewPager)

        binding.tvLoginHere.setOnClickListener {
            viewPager?.currentItem = 0
        }

        binding.btnRegister.setOnClickListener {
            registerToApp()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser != null) {
            firebaseUser = firebaseAuth.currentUser!!
        }
    }

    private fun registerToApp() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("Successfully registered")
                    sendEmailConfirmation()
                } else {
                    showToast("Please fill all details")
                }
            }
    }

    private fun sendEmailConfirmation() {
        if (this::firebaseAuth.isInitialized) {
            firebaseUser.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("Email verification is sent to your email")
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}