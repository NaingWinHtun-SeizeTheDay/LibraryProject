package com.seizetheday.library.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.CategoryVO
import com.seizetheday.library.delegates.CategoryDelegate
import com.seizetheday.library.viewholders.CategoryViewHolder

class CategoryAdapter(categoryDelegate: CategoryDelegate) : RecyclerView.Adapter<CategoryViewHolder>() {

    private var mCategoryViewHolder = categoryDelegate

    private var mCategory: List<CategoryVO> = ArrayList<CategoryVO>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viewholder_book_category, parent, false
            ), mCategoryViewHolder
        )
    }

    override fun onBindViewHolder(viewholder: CategoryViewHolder, position: Int) {
        viewholder.onBindData(mCategory[position])
    }

    override fun getItemCount(): Int {
        return mCategory.size
    }

    fun setCategoryData(category: List<CategoryVO>?) {
        if (category != null) {
            mCategory = category
        }
        notifyDataSetChanged()
    }

}