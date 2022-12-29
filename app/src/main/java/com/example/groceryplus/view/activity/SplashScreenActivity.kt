package com.example.groceryplus.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Telephony.Carriers.PASSWORD
import android.view.animation.AnimationUtils
import com.example.groceryplus.R
import com.example.groceryplus.databinding.ActivitySplashScreenBinding
import com.example.groceryplus.model.Constants.EMAIL
import com.example.groceryplus.model.Constants.LOGIN_DETAILS

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verifyLogin()
    }

    private fun doAnimationOnly() {
        val time: Long = 3000
        Handler().postDelayed(Runnable {
//            verifyLogin()
        }, time)

        val startAnimation = AnimationUtils.loadAnimation(this, R.anim.combine_two_anim)
        binding.apply {
            spark1.startAnimation(startAnimation)
            spark2.startAnimation(startAnimation)
            spark3.startAnimation(startAnimation)
            spark4.startAnimation(startAnimation)
            dot1.startAnimation(startAnimation)
            dot2.startAnimation(startAnimation)
            dot3.startAnimation(startAnimation)
        }
    }

    private fun verifyLogin() {
        val pref = getSharedPreferences(LOGIN_DETAILS, MODE_PRIVATE)
        if (pref.contains(EMAIL) && pref.contains(PASSWORD)) {
            doAnimationOnly()
            binding.imageView.setOnClickListener {
                startActivity(Intent(this, DashboardActivity::class.java))
            }
            startActivity(Intent(baseContext, DashboardActivity::class.java))
        } else {
            binding.imageView.setOnClickListener {
                startActivity(Intent(this, StartPagesActivity::class.java))
            }
            startActivity(Intent(baseContext, StartPagesActivity::class.java))
        }
    }
}