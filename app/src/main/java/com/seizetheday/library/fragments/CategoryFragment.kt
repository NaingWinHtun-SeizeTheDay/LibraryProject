package com.seizetheday.library.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.seizetheday.library.R
import com.seizetheday.library.adapters.CategoryAdapter
import com.seizetheday.library.delegates.CategoryDelegate
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(), CategoryDelegate {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //add recycler vite to adapter
        rv_book_category.layoutManager = LinearLayoutManager(context)
        rv_book_category.adapter = CategoryAdapter(this)
    }

    override fun onTapCategory() {
        Toast.makeText(context, "Tap", Toast.LENGTH_SHORT).show()
    }
}
