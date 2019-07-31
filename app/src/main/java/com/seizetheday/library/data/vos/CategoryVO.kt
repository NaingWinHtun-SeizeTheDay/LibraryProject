package com.seizetheday.library.data.vos

import com.google.gson.annotations.SerializedName

data class CategoryVO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("category_count")
    val categoryCount: Int
)