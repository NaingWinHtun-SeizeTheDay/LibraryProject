package com.seizetheday.library.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.seizetheday.library.R
import com.seizetheday.library.delegates.BookMarkDelegate

class BookMarkViewHolder(view: View) : BaseViewHolder(view) {

    constructor(itemView: View, bookMarkDelegate: BookMarkDelegate) : this(itemView) {

        //click for book name
        itemView.findViewById<TextView>(R.id.tv_book_mark_name).setOnClickListener {
            bookMarkDelegate.onTapBookName()
        }

        //click for book mark icon
        itemView.findViewById<ImageView>(R.id.iv_book_mark).setOnClickListener {
            bookMarkDelegate.onTapBookMark()
        }

        //click for book image
        itemView.findViewById<ImageView>(R.id.iv_book_mark_cover).setOnClickListener {
            bookMarkDelegate.onTapBookMarkImage()
        }
    }
}