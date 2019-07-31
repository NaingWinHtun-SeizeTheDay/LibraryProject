package com.seizetheday.library.network.dataagent

import com.seizetheday.library.events.BookDataEvent
import com.seizetheday.library.events.CategoryDataEvent
import com.seizetheday.library.events.PrimaryBookDataEvent
import com.seizetheday.library.network.apis.BookAPI
import com.seizetheday.library.network.apis.CategoryAPI
import com.seizetheday.library.network.apis.PrimaryBookAPI
import com.seizetheday.library.network.responses.BookResponse
import com.seizetheday.library.network.responses.CategoryResponse
import com.seizetheday.library.network.responses.PrimaryBookResponse
import com.seizetheday.library.utils.LibraryConstants.Companion.BASE_API
import com.seizetheday.library.utils.LibraryConstants.Companion.PRIMARY_BOOK_API
import com.seizetheday.library.utils.LibraryConstants.Companion.SECONDARY_BOOK_API
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitDataAgent {
    companion object {
        private var objInstance: RetrofitDataAgent? = null

        fun getObjInstance(): RetrofitDataAgent {
            if (objInstance == null) {
                objInstance = RetrofitDataAgent()
            }

            val obj = objInstance

            return obj!!
        }
    }

    private var mCategoryAPI: CategoryAPI
    private var mBookAPI: BookAPI
    private var mPrimaryBookAPI: PrimaryBookAPI

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val retrofitBook = Retrofit.Builder()
            .baseUrl(SECONDARY_BOOK_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val retrofitPrimaryBook = Retrofit.Builder()
            .baseUrl(PRIMARY_BOOK_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        mCategoryAPI = retrofit.create(CategoryAPI::class.java)
        mBookAPI = retrofitBook.create(BookAPI::class.java)
        mPrimaryBookAPI = retrofitPrimaryBook.create(PrimaryBookAPI::class.java)

    }

    fun loadCategory() {
        val response = mCategoryAPI.loadCategory()

        response.enqueue(object : Callback<CategoryResponse> {
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                EventBus.getDefault().post(CategoryDataEvent.EmptyDataLoadEvent(t.message))
            }

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                val categoryResponse: CategoryResponse? = response.body()
                if (categoryResponse != null) {
                    EventBus.getDefault()
                        .post(CategoryDataEvent.SuccessGetCategoryEvent(categoryResponse.getCategory()))
                }
            }
        })
    }

    fun loadBook() {
        val response = mBookAPI.loadBook()

        response.enqueue(object : Callback<BookResponse> {
            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                EventBus.getDefault().post(BookDataEvent.EmptyBookLoadEvent(t.message))
            }

            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                val bookResponse: BookResponse? = response.body()
                if (bookResponse != null) {
                    EventBus.getDefault().post(BookDataEvent.SuccessGetBookEvent(bookResponse.getBook()))
                }
            }

        })
    }

    fun loadPrimaryBook() {
        val response = mPrimaryBookAPI.loadPrimaryBook("popular_book")

        response.enqueue(object : Callback<PrimaryBookResponse> {
            override fun onFailure(call: Call<PrimaryBookResponse>, t: Throwable) {
                EventBus.getDefault().post(PrimaryBookDataEvent.EmptyPrimaryBookEvent(t.message))
            }

            override fun onResponse(call: Call<PrimaryBookResponse>, response: Response<PrimaryBookResponse>) {
                val bookResponse: PrimaryBookResponse? = response.body()
                if (bookResponse != null) {
                    EventBus.getDefault()
                        .post(PrimaryBookDataEvent.SuccessGetPrimaryBookEvent(bookResponse.getPopular()))
                }
            }
        })
    }

}