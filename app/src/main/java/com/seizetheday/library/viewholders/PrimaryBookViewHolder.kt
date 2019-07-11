package com.seizetheday.library.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.seizetheday.library.R
import com.seizetheday.library.delegates.PrimaryBookDelegate

class PrimaryBookViewHolder(view: View) : BaseViewHolder(view) {

    val rvPrimaryBook = view.findViewById<RecyclerView>(R.id.rv_primary_book)

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