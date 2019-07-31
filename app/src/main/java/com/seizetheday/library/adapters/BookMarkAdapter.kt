package com.seizetheday.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.delegates.BookMarkDelegate
import com.seizetheday.library.viewholders.BaseViewHolder
import com.seizetheday.library.viewholders.BookMarkViewHolder

class BookMarkAdapter(bookMarkDelegate: BookMarkDelegate) : BaseRecyclerViewAdapter<BaseViewHolder>() {

    private var mBookMarkDelegate = bookMarkDelegate

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseViewHolder {
        return BookMarkViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viewholder_book_mark,
                parent,
                false
            ), mBookMarkDelegate
        )
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
    }
}