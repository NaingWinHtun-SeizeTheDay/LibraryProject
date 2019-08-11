package com.seizetheday.library.viewholders

import android.support.v4.text.HtmlCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.delegates.SecondaryBookDelegate

class SecondaryBookViewHolder(view: View) : BaseViewHolder(view) {

    val rvSecondaryBook = view.findViewById<RecyclerView>(R.id.rv_secondary_book)
    private lateinit var mBook: BookVO

    constructor(itemView: View, mSecondaryBookDelegate: SecondaryBookDelegate) : this(itemView) {

        //whole secondary book item
        itemView.setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBook(mBook)
        }

        //secondary book mark
        itemView.findViewById<Button>(R.id.btn_secondary_book_mark).setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBookMark(mBook)
        }

        //secondary book share
        itemView.findViewById<ImageView>(R.id.iv_secondary_book_cover).setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBookImage(mBook)
        }
    }

    //set data into view holders
    override fun onBindData(book: BookVO, view: View) {
        mBook = book
        itemView.findViewById<TextView>(R.id.tv_secondary_book_name).text = mBook.bookName
        itemView.findViewById<TextView>(R.id.tv_secondary_book_author_name).text = mBook.authorName
        itemView.findViewById<TextView>(R.id.tv_secondary_book_description).text =
            HtmlCompat.fromHtml(mBook.bookDescription, 0)
        Glide.with(itemView).load(mBook.bookCover).into(itemView.findViewById(R.id.iv_secondary_book_cover))
        view.findViewById<TextView>(R.id.tv_book_title).visibility = View.VISIBLE
    }

}