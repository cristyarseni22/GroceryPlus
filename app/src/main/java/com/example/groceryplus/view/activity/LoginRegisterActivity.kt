package com.example.groceryplus.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.groceryplus.databinding.ActivityLoginRegisterBinding
import com.example.groceryplus.view.adapters.ViewPagerAdapter
import com.example.groceryplus.view.fragments.*

class LoginRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val fragmentList = arrayListOf<Fragment>(
            LoginFragment(),
            RegisterFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            supportFragmentManager,
            lifecycle
        )

        val viewPager = binding.loginRegisterViewPager
        viewPager.adapter = adapter
    }
}

//private fun initViews() {
//    binding.apply {
//        btnRegister.setOnClickListener {
//            btnLogin.isActivated = false
//            regFragment = RegistrationFragment()
//            supportFragmentManager.beginTransaction().replace(R.id.flLogin, regFragment)
//                .commit()
//        }
//        btnLogin.setOnClickListener {
//            btnRegister.isActivated = false
//            supportFragmentManager.beginTransaction().replace(R.id.flLogin, loginFragment)
//                .commit()
//        }
//    }
//}