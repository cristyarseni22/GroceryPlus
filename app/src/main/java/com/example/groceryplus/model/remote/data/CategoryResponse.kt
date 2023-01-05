package com.example.groceryplus.model.remote.data

import java.io.Serializable

data class CategoryResponse(
    val count: Int = -1,
    val `data`: List<CategoryData>,
    val error: Boolean = false
)

data class CategoryData(
    val __v: Int = -1,
    val _id: String = "",
    val catDescription: String = "",
    val catId: Int = -1,
    val catImage: String,
    val catName: String,
    val position: Int = -1,
    val slug: String = "",
    val status: Boolean = false
) : Serializable {
    companion object {
        const val KEY_CATEGORY = "category"
    }
}
