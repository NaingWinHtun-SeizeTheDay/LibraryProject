package com.seizetheday.library.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.seizetheday.library.R
import com.seizetheday.library.adapters.BookMarkAdapter
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        rv_profile_books.layoutManager = LinearLayoutManager(this)
        rv_profile_books.adapter = BookMarkAdapter()
    }
}
