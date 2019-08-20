package com.seizetheday.library.viewholders

import android.view.View
import android.widget.TextView
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.SearchBookVO
import com.seizetheday.library.delegates.SearchBookDelegate

class SearchViewHolder(itemView: View) : BaseViewHolder(itemView) {

    private lateinit var mSearchBook: SearchBookVO

    constructor(itemView: View, searchBookDelegate: SearchBookDelegate) : this(itemView) {
        //whole book item
        itemView.setOnClickListener {
            searchBookDelegate.onTapSearchBook(mSearchBook)
        }
    }

    fun onBindData(item: SearchBookVO) {

        mSearchBook = item

        itemView.findViewById<TextView>(R.id.tv_book_result_name).text = mSearchBook.bookName
    }
}