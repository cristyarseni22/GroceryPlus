package com.example.groceryplus.model.remote

import com.example.groceryplus.model.Constants.CATEGORY_END_POINT
import com.example.groceryplus.model.remote.data.CategoryData
import com.example.groceryplus.model.remote.data.CategoryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(CATEGORY_END_POINT)
    fun getCategory(): Single<CategoryData>
}