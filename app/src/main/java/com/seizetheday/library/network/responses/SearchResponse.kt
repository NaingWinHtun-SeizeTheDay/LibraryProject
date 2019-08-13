package com.seizetheday.library.network.responses

import com.google.gson.annotations.SerializedName
import com.seizetheday.library.data.vos.SearchBookVO

class SearchResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("books")
    private var books: MutableList<SearchBookVO>? = null


    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getBook(): MutableList<SearchBookVO>? {
        if (books == null) {
            books = ArrayList()
        }

        val obj = books

        return obj!!

    }

}