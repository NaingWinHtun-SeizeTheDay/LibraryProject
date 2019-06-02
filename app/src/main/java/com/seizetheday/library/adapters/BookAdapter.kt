package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.viewholders.PrimaryBookViewHolder

class BookAdapter : RecyclerView.Adapter<PrimaryBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PrimaryBookViewHolder {
        return PrimaryBookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_primary, parent, false))

    }

    override fun onBindViewHolder(p0: PrimaryBookViewHolder, p1: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

}