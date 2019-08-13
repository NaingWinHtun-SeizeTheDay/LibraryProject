package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.SearchBookVO
import com.seizetheday.library.viewholders.SearchViewHolder

class SearchAdapter(searchBookVO: MutableList<SearchBookVO>) : RecyclerView.Adapter<SearchViewHolder>() {

    val mSearchBookVO = searchBookVO

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.viewholder_search_books, viewGroup, false)
        )
    }

    override fun getItemCount(): Int {
        return mSearchBookVO.size
    }

    override fun onBindViewHolder(viewholder: SearchViewHolder, position: Int) {
        viewholder.onBindData(mSearchBookVO[position])
    }

}