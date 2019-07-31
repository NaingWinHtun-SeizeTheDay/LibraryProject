package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.PrimaryBookVO
import com.seizetheday.library.delegates.PrimaryBookDelegate
import com.seizetheday.library.viewholders.PrimaryBookViewHolder

class PrimaryBookAdapter(primaryBookDelegate: PrimaryBookDelegate) : RecyclerView.Adapter<PrimaryBookViewHolder>() {

    private var mPrimaryBookDelegate = primaryBookDelegate
    private var mPrimaryBookData: List<PrimaryBookVO> = ArrayList()
    private lateinit var mView: View

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): PrimaryBookViewHolder {
        return PrimaryBookViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.viewholder_primary_book,
                viewGroup,
                false
            ), mPrimaryBookDelegate
        )
    }

    override fun getItemCount(): Int {
        return mPrimaryBookData.size
    }

    override fun onBindViewHolder(viewholder: PrimaryBookViewHolder, position: Int) {
        viewholder.onBindData(mPrimaryBookData[position], mView)
    }

    fun setPrimaryBookData(books: List<PrimaryBookVO>, view: View) {
        mPrimaryBookData = books
        mView = view
    }
}