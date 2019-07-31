package com.seizetheday.library.network.responses

import com.google.gson.annotations.SerializedName
import com.seizetheday.library.data.vos.PrimaryBookVO

class PrimaryBookResponse {

    @SerializedName("popular")
    private var primaryBook: List<PrimaryBookVO>? = null

    fun getPopular(): List<PrimaryBookVO>? {
        if (primaryBook == null) {
            primaryBook = ArrayList()
        }

        val obj = primaryBook

        return obj!!

    }

}