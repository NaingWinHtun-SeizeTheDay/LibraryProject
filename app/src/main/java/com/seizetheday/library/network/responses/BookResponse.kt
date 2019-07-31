package com.seizetheday.library.network.responses

import com.google.gson.annotations.SerializedName
import com.seizetheday.library.data.vos.BookVO

class BookResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("books")
    private var books: List<BookVO>? = null


    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getBook(): List<BookVO>? {
        if (books == null) {
            books = ArrayList()
        }

        val obj = books

        return obj!!

    }

}