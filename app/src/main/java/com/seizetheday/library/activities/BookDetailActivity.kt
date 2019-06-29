package com.seizetheday.library.activities

import android.os.Bundle
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
    }
}