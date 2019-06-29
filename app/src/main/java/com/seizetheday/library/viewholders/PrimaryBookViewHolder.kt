package com.seizetheday.library.viewholders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.BooksVO
import com.seizetheday.library.delegates.PrimaryBookDelegate

class PrimaryBookViewHolder(view: View) : BaseViewHolder(view) {

    var primaryBookCoverImage: ImageView = view.findViewById(R.id.iv_primary_book_cover) as ImageView
    var primaryBookNumber: TextView = view.findViewById(R.id.tv_primary_book_number) as TextView
    var primaryBookName: TextView = view.findViewById(R.id.tv_primary_book_name) as TextView
    var primaryBookAuthor: TextView = view.findViewById(R.id.tv_primary_book_author_name) as TextView
    var primaryBookDescription: TextView = view.findViewById(R.id.tv_primary_book_description) as TextView

    //bind data
    override fun onBindData(bookVO: BooksVO) {

        Glide.with(itemView.context).load(bookVO.bookCoverImage).into(primaryBookCoverImage)
        primaryBookNumber.text = bookVO.bookId.toString()
        primaryBookName.text = bookVO.bookName
        primaryBookAuthor.text = bookVO.bookAuthorName
        primaryBookDescription.text = bookVO.bookDescription
    }

    constructor(itemView: View, primaryBookDelegate: PrimaryBookDelegate) : this(itemView) {
        //whole book item
        itemView.setOnClickListener {
            primaryBookDelegate.onTapPrimaryBook()
        }

        //download button
        itemView.findViewById<Button>(R.id.btn_primary_book_download).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookDownload()
        }

        //share button
        itemView.findViewById<Button>(R.id.btn_primary_book_share).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookShare()
        }

        //book mark button
        itemView.findViewById<ImageView>(R.id.fab_primary_book_mark).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookMark()
        }

        //image
        itemView.findViewById<ImageView>(R.id.iv_primary_book_cover).setOnClickListener {
            primaryBookDelegate.onTapPrimaryBookImage()
        }

    }
}