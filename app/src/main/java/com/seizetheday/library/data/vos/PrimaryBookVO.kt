package com.seizetheday.library.data.vos

import com.google.gson.annotations.SerializedName

data class PrimaryBookVO(
    @SerializedName("b_id")
    val bookId: String,
    @SerializedName("b_name")
    val bookName: String,
    @SerializedName("b_author")
    val authorName: String,
    @SerializedName("b_image")
    val bookCover: String,
    @SerializedName("b_category")
    val bookCategory: String,
    @SerializedName("b_release_year")
    val bookReleaseYear: String,
    @SerializedName("b_pdf")
    val bookPdf: String
)