package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.delegates.SecondaryBookDelegate
import com.seizetheday.library.viewholders.SecondaryBookViewHolder

class SecondaryBookAdapter(secondaryBookDelegate: SecondaryBookDelegate) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mSecondaryBookDelegate = secondaryBookDelegate
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SecondaryBookViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.viewholder_secondary_book,
                viewGroup,
                false
            ), mSecondaryBookDelegate
        )
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
    }
}