package com.seizetheday.library.viewpod

import android.content.Context
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_empty.view.*

class EmptyView(context: Context?) : RelativeLayout(context) {

    public fun setEmptyView(emptyImageUrl: String, errorMessage: String) {
        Glide.with(this).load(emptyImageUrl).into(iv_empty_image)
        tv_error_message.text = errorMessage
    }

    public fun setEmptyView(emptyImageUrl: Int, errorMessage: String) {
        Glide.with(this).load(emptyImageUrl).into(iv_empty_image)
        tv_error_message.text = errorMessage
    }

}