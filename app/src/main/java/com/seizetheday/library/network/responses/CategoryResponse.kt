package com.seizetheday.library.network.responses

import com.google.gson.annotations.SerializedName
import com.seizetheday.library.data.vos.CategoryVO

class CategoryResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("category")
    private var category: List<CategoryVO>? = null


    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getCategory(): List<CategoryVO>? {
        if (category == null) {
            category = ArrayList()
        }

        val obj = category

        return obj!!

    }

}