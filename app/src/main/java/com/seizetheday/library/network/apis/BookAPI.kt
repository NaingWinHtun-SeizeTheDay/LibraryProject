package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.BookResponse
import com.seizetheday.library.utils.LibraryConstants.Companion.GET_BOOK
import retrofit2.Call
import retrofit2.http.POST

interface BookAPI {
    @POST(GET_BOOK)
    fun loadBook(): Call<BookResponse>
}