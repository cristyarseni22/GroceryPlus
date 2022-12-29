package com.example.groceryplus.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.groceryplus.databinding.ActivityStartPagesBinding
import com.example.groceryplus.view.adapters.ViewPagerAdapter
import com.example.groceryplus.view.fragments.FirstPageFragment
import com.example.groceryplus.view.fragments.SecondPageFragment
import com.example.groceryplus.view.fragments.ThirdPageFragment

class StartPagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartPagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartPagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
    }

    private fun initView() {
        val fragmentList = arrayListOf<Fragment>(
            FirstPageFragment(),
            SecondPageFragment(),
            ThirdPageFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            supportFragmentManager,
            lifecycle
        )

        val viewPager = binding.vpContainer
        viewPager.adapter = adapter

        val wormDotsIndicator = binding.wormDotsIndicator
        wormDotsIndicator.attachTo(viewPager)
    }
}