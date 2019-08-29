package com.seizetheday.library.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import com.seizetheday.library.R
import com.seizetheday.library.data.models.BookModel
import com.seizetheday.library.data.models.PrimaryBookModel
import kotlinx.android.synthetic.main.activity_book_read.*


class BookReadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_read)

        val idFromIntent = intent.getIntExtra("bookUrl", 0)

        val mBook = BookModel.getObjInstance().getBookById(idFromIntent)
        val mPrimaryBook = PrimaryBookModel.getObjInstance().getBookById(idFromIntent)

        var pdfUrl = ""

        if (mBook != null) {
            pdfUrl = mBook.book
        } else if (mPrimaryBook != null) {
            pdfUrl = mPrimaryBook.book
        }

        wvBookRead.webViewClient = WebViewClient()
        wvBookRead.settings.javaScriptEnabled = true

        wvBookRead.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdfUrl")
    }

}
