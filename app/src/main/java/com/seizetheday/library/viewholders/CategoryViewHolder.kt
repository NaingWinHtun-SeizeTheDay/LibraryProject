package com.seizetheday.library.viewholders

import android.view.View
import android.widget.TextView
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.CategoryVO
import com.seizetheday.library.delegates.CategoryDelegate

class CategoryViewHolder(view: View) : BaseViewHolder(view) {

    constructor(itemView: View, categoryDelegate: CategoryDelegate) : this(itemView) {

        //click on whole category item
        itemView.setOnClickListener {
            categoryDelegate.onTapCategory()
        }
    }

    fun onBindData(category: CategoryVO) {
        itemView.findViewById<TextView>(R.id.tv_book_category_name).text = category.categoryName
        itemView.findViewById<TextView>(R.id.tv_book_category_number).text = category.categoryCount.toString()
    }
}