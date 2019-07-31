package com.seizetheday.library.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.seizetheday.library.R
import com.seizetheday.library.activities.BookDetailActivity
import com.seizetheday.library.adapters.BookMarkAdapter
import com.seizetheday.library.delegates.BookMarkDelegate
import kotlinx.android.synthetic.main.fragment_book_mark.*

class BookMarkFragment : Fragment(), BookMarkDelegate {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_mark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //add recycler vite to adapter

        //set up adapter to recycler view
        rv_book_mark.layoutManager = GridLayoutManager(context, 3)
        rv_book_mark.adapter = BookMarkAdapter(this)

        srlBookMark.isRefreshing = false

        srlBookMark.setOnRefreshListener {
        }
    }

    override fun onTapBookMark() {
        Toast.makeText(context, "Tap to remove", Toast.LENGTH_SHORT).show()
    }

    override fun onTapBookName() {
        Toast.makeText(context, "Tap", Toast.LENGTH_SHORT).show()
    }

    override fun onTapBookMarkImage() {
        startActivity(Intent(context, BookDetailActivity::class.java))
    }

}