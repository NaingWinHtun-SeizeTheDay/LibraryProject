package com.seizetheday.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.BooksVO
import com.seizetheday.library.delegates.PrimaryBookDelegate
import com.seizetheday.library.viewholders.BaseViewHolder
import com.seizetheday.library.viewholders.PrimaryBookViewHolder

class BookAdapter(var bookList: ArrayList<BooksVO>, primaryBookDelegate: PrimaryBookDelegate) :
    BaseRecyclerViewAdapter<BaseViewHolder>() {

    private val mPrimaryBookDelegate = primaryBookDelegate

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PrimaryBookViewHolder {
        return PrimaryBookViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_primary_book, parent, false)
            , mPrimaryBookDelegate
        )
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        viewHolder.onBindData(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}