package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.viewholders.BlogViewHolder

class BlogPostAdapter : RecyclerView.Adapter<BlogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BlogViewHolder {
        return BlogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_blog_post, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: BlogViewHolder, p1: Int) {
    }
}