package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.PrimaryBookResponse
import com.seizetheday.library.utils.LibraryConstants
import retrofit2.Call
import retrofit2.http.POST

interface PrimaryBookAPI {
    @POST(LibraryConstants.GET_PRIMARY_BOOK)
    fun loadPrimaryBook(): Call<PrimaryBookResponse>
}