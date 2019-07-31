package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.delegates.SecondaryBookDelegate
import com.seizetheday.library.viewholders.BaseViewHolder
import com.seizetheday.library.viewholders.SecondaryBookViewHolder

class SecondaryBookAdapter(secondaryBookDelegate: SecondaryBookDelegate) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var mSecondaryBookDelegate = secondaryBookDelegate
    private var mSecondaryBooks: List<BookVO> = ArrayList()
    private lateinit var mView: View

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        return SecondaryBookViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.viewholder_secondary_book,
                viewGroup,
                false
            ), mSecondaryBookDelegate
        )
    }

    override fun getItemCount(): Int {
        return mSecondaryBooks.size
    }

    override fun onBindViewHolder(viewholder: BaseViewHolder, position: Int) {
        viewholder.onBindData(mSecondaryBooks[position], mView)
    }

    fun setSecondaryBookData(primaryBooks: List<BookVO>, view: View) {
        mSecondaryBooks = primaryBooks
        mView = view
    }
}