package com.seizetheday.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.delegates.CategoryDelegate
import com.seizetheday.library.viewholders.BaseViewHolder
import com.seizetheday.library.viewholders.CategoryViewHolder

class CategoryAdapter(categoryDelegate: CategoryDelegate) : BaseRecyclerViewAdapter<BaseViewHolder>() {

    private var mCategoryViewHolder = categoryDelegate

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viewholder_book_category, parent, false
            ), mCategoryViewHolder
        )
    }

    override fun onBindViewHolder(viewholder: BaseViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 50
    }

}