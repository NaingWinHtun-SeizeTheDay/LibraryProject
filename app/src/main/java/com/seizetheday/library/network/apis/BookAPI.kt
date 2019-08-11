package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.BookResponse
import com.seizetheday.library.utils.LibraryConstants.Companion.GET_SECONDARY_BOOK
import retrofit2.Call
import retrofit2.http.POST

interface BookAPI {
    @POST(GET_SECONDARY_BOOK)
    fun loadBook(): Call<BookResponse>
}