package com.seizetheday.library.network.apis

import com.seizetheday.library.network.responses.CategoryResponse
import com.seizetheday.library.utils.LibraryConstants.Companion.GET_CATEGORY
import retrofit2.Call
import retrofit2.http.POST

interface CategoryAPI {

    @POST(GET_CATEGORY)
    fun loadCategory(): Call<CategoryResponse>
}