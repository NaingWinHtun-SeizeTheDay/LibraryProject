package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import com.bumptech.glide.Glide
import com.seizetheday.library.R
import com.seizetheday.library.data.models.BookModel
import com.seizetheday.library.data.models.PrimaryBookModel
import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.data.vos.PrimaryBookVO
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        setSupportActionBar(book_detail_tool_bar)

        val idFromIntent = intent.getIntExtra("bookId", 0)

        val mBook = BookModel.getObjInstance().getBookById(idFromIntent)
        val mPrimaryBook = PrimaryBookModel.getObjInstance().getBookById(idFromIntent)

        //for primary book
        if (mPrimaryBook == null) {
            //show empty view
        } else {
            onBindPrimaryBookDetailData(mPrimaryBook)
        }

        //for books
        if (mBook == null) {
            //show empty view
        } else {
            onBindBookDetailData(mBook)
        }

        //navigation back button
        book_detail_tool_bar.setNavigationOnClickListener {
            finishAndRemoveTask()
        }

        //book read
        btn_book_detail_read.setOnClickListener {
            val intent = Intent(this@BookDetailActivity, BookReadActivity::class.java)
            var bookId: Int = mBook?.id ?: mPrimaryBook!!.id
            intent.putExtra("bookUrl", bookId)
            startActivity(intent)
        }

        //book share
        btn_book_detail_share.setOnClickListener {

            var bookLink: String = mBook?.book ?: mPrimaryBook!!.book

            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, bookLink)
            }
            startActivity(intent)
        }
    }

    //bind data
    private fun onBindBookDetailData(book: BookVO) {
        tv_book_detail_name.text = book.bookName
        tv_book_detail_author_name.text = "Author : " + book.authorName
        tv_book_detail_isbn.text = "ISBN : " + book.bookIsbn
        tv_book_detail_edition.text = "Edition : " + book.bookEdition
        tv_book_detail_text.text = HtmlCompat.fromHtml(book.bookDescription, 0)
        Glide.with(this).load(book.bookCover).into(iv_book_detail_cover)
    }

    //bind data
    private fun onBindPrimaryBookDetailData(book: PrimaryBookVO) {
        tv_book_detail_name.text = book.bookName
        tv_book_detail_author_name.text = "Author : " + book.authorName
        tv_book_detail_isbn.text = "ISBN : " + book.bookIsbn
        tv_book_detail_text.text = HtmlCompat.fromHtml(book.bookDescription, 0)
        Glide.with(this).load(book.bookCover).into(iv_book_detail_cover)
    }
}