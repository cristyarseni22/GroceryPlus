package com.example.groceryplus.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.groceryplus.databinding.ActivityDashboardBinding
import com.example.groceryplus.model.remote.data.CategoryData
import com.example.groceryplus.model.remote.data.CategoryResponse
import com.example.groceryplus.view.adapters.CategoryAdapter
import com.example.groceryplus.viewModel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var viewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupObserver()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        viewModel.getCategory()
    }

    private fun setupObserver() {
        with(viewModel) {
            categoryResponse.observe(this@DashboardActivity) {
//                Glide.with(this@DashboardActivity)
//                    .load(it.catImage)
//                    .placeholder(R.drawable.loading)
//                    .error(android.R.drawable.ic_dialog_alert)
//                    .into(binding.tvCategory)
                Log.i("tag", "success")
            }
        }
    }

    fun setCategoryResult(result: CategoryResponse) {
        categoryAdapter = CategoryAdapter(this, result.data)
//        categoryAdapter.setOnOptionSelectListener { category, _ ->
//            val intent = Intent(baseContext, SubcategoryActivity::class.java)
//            intent.putExtra(CategoryData.KEY_CATEGORY, category.catId)
//            startActivity(intent)
//            finish()
//        }

        val categoryList = ArrayList<CategoryData>()
        for (i in result.data.indices) {
            categoryList.add(result.data[i])
            binding.rvCategory.layoutManager =
                GridLayoutManager(this, 2)
            binding.rvCategory.adapter = categoryAdapter
        }

        binding.rvCategory.setOnClickListener {
            binding.rvCategory.adapter = categoryAdapter
        }
    }

}