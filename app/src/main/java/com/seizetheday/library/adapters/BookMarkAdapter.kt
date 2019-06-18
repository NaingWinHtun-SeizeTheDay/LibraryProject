package com.seizetheday.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.viewholders.BaseViewHolder
import com.seizetheday.library.viewholders.BookMarkViewHolder

class BookMarkAdapter : BaseRecyclerViewAdapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseViewHolder {
        return BookMarkViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viewholder_profile_book_mark,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 50
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
    }
}