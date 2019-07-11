package com.seizetheday.library.viewholders

import android.view.View
import com.seizetheday.library.delegates.CategoryDelegate

class CategoryViewHolder(view: View) : BaseViewHolder(view) {

    constructor(itemView: View, categoryDelegate: CategoryDelegate) : this(itemView) {

        //click on whole category item
        itemView.setOnClickListener {
            categoryDelegate.onTapCategory()
        }
    }
}