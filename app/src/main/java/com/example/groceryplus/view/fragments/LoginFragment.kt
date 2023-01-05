package com.example.groceryplus.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.groceryplus.R
import com.example.groceryplus.databinding.FragmentLoginBinding
import com.example.groceryplus.view.activity.DashboardActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(
            layoutInflater,
            container,
            false
        )
        val viewPager = activity?.findViewById<ViewPager2>(R.id.login_register_viewPager)

        binding.tvRegisterHere.setOnClickListener {
            viewPager?.currentItem = 1
        }

//        binding.btnLogin.setOnClickListener {
//            startActivity(Intent(context, DashboardActivity::class.java))
//        }
        binding.btnLogin.setOnClickListener {
            loginToApp()
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

    private fun loginToApp() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("Logged in Successfully")
                    if (firebaseAuth.currentUser != null) {
                        firebaseUser = firebaseAuth.currentUser!!
                    }
                    startActivity(Intent(context, DashboardActivity::class.java))
                } else {
                    showToast("Wrong credentials. Try Again!!")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}