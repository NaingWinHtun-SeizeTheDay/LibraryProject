package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.delegates.PrimaryBookDelegate
import com.seizetheday.library.viewholders.PrimaryBookViewHolder

class PrimaryBookAdapter(primaryBookDelegate: PrimaryBookDelegate) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPrimaryBookDelegate = primaryBookDelegate

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return PrimaryBookViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.viewholder_primary_book,
                viewGroup,
                false
            ), mPrimaryBookDelegate
        )
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
    }
}