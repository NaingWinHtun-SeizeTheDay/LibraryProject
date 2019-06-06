package com.seizetheday.library.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.seizetheday.library.R
import com.seizetheday.library.adapters.BookAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_book_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rv_book_list.adapter = BookAdapter()

    }
}