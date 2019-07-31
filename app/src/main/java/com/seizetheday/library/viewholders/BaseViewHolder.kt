package com.seizetheday.library.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.data.vos.PrimaryBookVO

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun onBindData() {
    }

    open fun onBindData(books: BookVO) {
    }

    open fun onBindData(books: BookVO, view: View) {
    }

    open fun onBindData(books: PrimaryBookVO, view: View) {
    }
}