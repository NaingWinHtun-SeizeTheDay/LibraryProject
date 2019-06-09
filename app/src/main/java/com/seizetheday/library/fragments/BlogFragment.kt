package com.seizetheday.library.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seizetheday.library.R
import com.seizetheday.library.adapters.BlogPostAdapter
import kotlinx.android.synthetic.main.fragment_blog.*

class BlogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler view of blog post
        rv_blog_post.layoutManager = LinearLayoutManager(context)
        rv_blog_post.adapter = BlogPostAdapter()
    }
}
