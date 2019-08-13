package com.seizetheday.library.viewholders

import android.view.View
import android.widget.TextView
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.SearchBookVO

class SearchViewHolder(itemView: View) : BaseViewHolder(itemView) {
    fun onBindData(item: SearchBookVO) {
        itemView.findViewById<TextView>(R.id.tv_book_result_name).text = item.bookName
    }
}