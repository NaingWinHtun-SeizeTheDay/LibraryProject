package com.seizetheday.library.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun onBindData() {
    }
}