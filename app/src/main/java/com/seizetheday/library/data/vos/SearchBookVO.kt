package com.seizetheday.library.data.vos

import com.google.gson.annotations.SerializedName

data class SearchBookVO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("book_name")
    val bookName: String,
    @SerializedName("author_name")
    val authorName: String,
    @SerializedName("book_description")
    val bookDescription: String,
    @SerializedName("book_edition")
    val bookEdition: String,
    @SerializedName("book_isbn")
    val bookIsbn: String,
    @SerializedName("book_download_rate")
    val bookDownloadRate: String,
    @SerializedName("book_cover")
    val bookCover: String
)