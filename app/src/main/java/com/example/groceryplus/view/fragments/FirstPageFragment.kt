package com.example.groceryplus.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.groceryplus.R
import com.example.groceryplus.databinding.FragmentFirstPageBinding

class FirstPageFragment : Fragment() {
    private lateinit var binding: FragmentFirstPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPageBinding.inflate(
            layoutInflater,
            container,
            false
        )

        val viewPager = activity?.findViewById<ViewPager2>(R.id.vp_container)

        binding.tvSkip.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return binding.root
    }
}
