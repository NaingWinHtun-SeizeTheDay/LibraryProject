package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.PrimaryBookResponse
import com.seizetheday.library.utils.LibraryConstants.Companion.GET_PRIMARY_BOOK
import retrofit2.Call
import retrofit2.http.POST

interface PrimaryBookAPI {
    @POST(GET_PRIMARY_BOOK)
    fun loadPrimaryBook(): Call<PrimaryBookResponse>
}