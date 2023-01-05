package com.example.groceryplus.model

import com.example.groceryplus.model.remote.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService){
    fun getCategoryData() = apiService.getCategory()
}