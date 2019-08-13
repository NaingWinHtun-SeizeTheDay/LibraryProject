package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.SearchResponse
import com.seizetheday.library.utils.LibraryConstants.Companion.GET_SEARCH
import retrofit2.Call
import retrofit2.http.POST

interface SearchBookAPI {

    @POST(GET_SEARCH)
    fun searchBooks(): Call<SearchResponse>
}