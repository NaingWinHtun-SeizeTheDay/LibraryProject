package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.seizetheday.library.R
import com.seizetheday.library.data.models.BookModel
import com.seizetheday.library.data.vos.BookVO
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        setSupportActionBar(book_detail_tool_bar)

        val mBook = BookModel.getObjInstance().getBookById(intent.getIntExtra("bookId", 0))

        if (mBook == null) {
            //show empty view
        } else {
            onBindBookDetailData(mBook)
        }

        //navigation back button
        book_detail_tool_bar.setNavigationOnClickListener {
            finishAndRemoveTask()
        }

        fl_book_detail_download.setOnClickListener {
            startActivity(Intent(this@BookDetailActivity, LoginActivity::class.java))
        }

        fl_book_detail_read.setOnClickListener {
            Toast.makeText(this, "Tap", Toast.LENGTH_SHORT).show()
        }
    }

    //bind data
    private fun onBindBookDetailData(book: BookVO) {
        tv_book_detail_name.text = book.bookName
        tv_book_detail_author_name.text = book.authorName
        tv_book_detail_isbn.text = "ISBN : " + book.bookIsbn
        tv_book_detail_text.text = book.bookDescription
        Glide.with(this).load(book.bookCover).into(iv_book_detail_cover)
    }
}