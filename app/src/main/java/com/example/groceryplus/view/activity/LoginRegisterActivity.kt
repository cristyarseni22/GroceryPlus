package com.example.groceryplus.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groceryplus.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initView()
    }

//    private fun initView() {
//        val fragmentAdapter = LoginRegisterFragmentsAdapter(supportFragmentManager)
//        val viewPager = binding.viewPager
//        viewPager.adapter = fragmentAdapter
//    }

//    private fun initViews() {
//        binding.apply {
//            btnRegister.setOnClickListener {
//                btnLogin.isActivated = false
//                regFragment = RegistrationFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.flLogin, regFragment)
//                    .commit()
//            }
//            btnLogin.setOnClickListener {
//                btnRegister.isActivated = false
//                supportFragmentManager.beginTransaction().replace(R.id.flLogin, loginFragment)
//                    .commit()
//            }
//        }
//    }
}