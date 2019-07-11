package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.seizetheday.library.R
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        setSupportActionBar(book_detail_tool_bar)

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
}