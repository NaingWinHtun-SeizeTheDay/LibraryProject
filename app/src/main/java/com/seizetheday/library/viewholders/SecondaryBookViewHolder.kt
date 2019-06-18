package com.seizetheday.library.viewholders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.seizetheday.library.R
import com.seizetheday.library.delegates.SecondaryBookDelegate

class SecondaryBookViewHolder(view: View) : BaseViewHolder(view) {

    constructor(itemView: View, mSecondaryBookDelegate: SecondaryBookDelegate) : this(itemView) {

        //whole secondary book item
        itemView.setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBook()
        }

        //secondary book mark
        itemView.findViewById<Button>(R.id.btn_secondary_book_mark).setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBookMark()
        }

        //secondary book read
        itemView.findViewById<Button>(R.id.btn_secondary_read).setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBookRead()
        }

        //secondary book share
        itemView.findViewById<Button>(R.id.btn_secondary_share).setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBookShare()
        }

        //secondary book share
        itemView.findViewById<ImageView>(R.id.iv_secondary_book_cover).setOnClickListener {
            mSecondaryBookDelegate.onTapSecondaryBookImage()
        }
    }

}