package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.PrimaryBookResponse
import com.seizetheday.library.utils.LibraryConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PrimaryBookAPI {
    @GET(LibraryConstants.GET_PRIMARY_BOOK)
    fun loadPrimaryBook(@Query("value") primaryBook: String): Call<PrimaryBookResponse>
}