package com.seizetheday.library.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seizetheday.library.R
import com.seizetheday.library.adapters.BookMarkAdapter
import kotlinx.android.synthetic.main.fragment_book_mark.*

class BookMarkFragment : Fragment() {

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
        rv_book_mark.adapter = BookMarkAdapter()
    }
}
