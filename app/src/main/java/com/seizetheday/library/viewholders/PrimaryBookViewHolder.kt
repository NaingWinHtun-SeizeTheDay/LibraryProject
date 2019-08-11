package com.seizetheday.library.viewholders

import android.support.v4.text.HtmlCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.PrimaryBookVO
import com.seizetheday.library.delegates.PrimaryBookDelegate

class PrimaryBookViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var mBook: PrimaryBookVO

    val rvPrimaryBook = view.findViewById<RecyclerView>(R.id.rv_primary_book)

    constructor(itemView: View, primaryBookDelegate: PrimaryBookDelegate) : this(itemView) {
        //whole book item
        itemView.setOnClickListener {
            primaryBookDelegate.onTapPrimaryBook(mBook)
        }

        //download button
        itemView.findViewById<Button>(R.id.btn_primary_book_download).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookDownload(mBook)
        }

        //share button
        itemView.findViewById<Button>(R.id.btn_primary_book_read).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookRead(mBook)
        }

        //book mark button
        itemView.findViewById<ImageView>(R.id.fab_primary_book_mark).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookMark(mBook)
        }

        //image
        itemView.findViewById<ImageView>(R.id.iv_primary_book_cover).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookImage(mBook)
        }

    }

    override fun onBindData(book: PrimaryBookVO, view: View) {
        mBook = book
        itemView.findViewById<TextView>(R.id.tv_primary_book_name).text = mBook.bookName
        itemView.findViewById<TextView>(R.id.tv_primary_book_author_name).text = mBook.authorName
        itemView.findViewById<TextView>(R.id.tv_primary_book_number).text = mBook.id.toString()
        itemView.findViewById<TextView>(R.id.tv_primary_book_description).text = HtmlCompat.fromHtml(mBook.bookDescription,0)
        Glide.with(itemView).load(mBook.bookCover).into(itemView.findViewById(R.id.iv_primary_book_cover))
        //for text visibility
        view.findViewById<TextView>(R.id.tv_popular_title).visibility = View.VISIBLE
    }
}