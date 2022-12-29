package com.example.groceryplus.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.groceryplus.R
import com.example.groceryplus.databinding.FragmentSecondPageBinding
import com.example.groceryplus.databinding.FragmentThirdPageBinding
import com.example.groceryplus.view.activity.LoginRegisterActivity
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class ThirdPageFragment : Fragment() {
    private var _binding: FragmentThirdPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdPageBinding.inflate(
            inflater,
            container,
            false
        )

        val viewPager = activity?.findViewById<ViewPager2>(R.id.vp_container)


        return binding.root
    }
}