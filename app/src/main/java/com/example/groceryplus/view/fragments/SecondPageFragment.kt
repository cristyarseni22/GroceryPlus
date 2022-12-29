package com.example.groceryplus.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.groceryplus.R
import com.example.groceryplus.databinding.FragmentFirstPageBinding
import com.example.groceryplus.databinding.FragmentSecondPageBinding

class SecondPageFragment : Fragment() {
    private lateinit var binding: FragmentSecondPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondPageBinding.inflate(
            layoutInflater,
            container,
            false
        )

        val viewPager = activity?.findViewById<ViewPager2>(R.id.vp_container)

        binding.tvSkip1.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return binding.root
    }
}