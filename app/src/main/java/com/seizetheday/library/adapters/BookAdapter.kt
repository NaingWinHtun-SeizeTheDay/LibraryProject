package com.seizetheday.library.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seizetheday.library.R
import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.data.vos.PrimaryBookVO
import com.seizetheday.library.delegates.PrimaryBookDelegate
import com.seizetheday.library.delegates.SecondaryBookDelegate
import com.seizetheday.library.viewholders.BaseViewHolder
import com.seizetheday.library.viewholders.PrimaryBookViewHolder
import com.seizetheday.library.viewholders.SecondaryBookViewHolder

class BookAdapter(primaryBookDelegate: PrimaryBookDelegate, secondaryBookDelegate: SecondaryBookDelegate) :
    BaseRecyclerViewAdapter<BaseViewHolder>() {

    private val VT_PRIMARY_BOOK: Int = 1000
    private val VT_SECONDARY_BOOK: Int = 2000
    private lateinit var mViewHolder: BaseViewHolder
    private var context: Context? = null
    private var mPirmaryBookData: List<PrimaryBookVO> = ArrayList()
    private var mSecondaryBookData: List<BookVO> = ArrayList()
    private val snapHelper = PagerSnapHelper()
    private lateinit var primaryView: View
    private lateinit var secondaryView: View

    private lateinit var mPrimaryBookAdapter: PrimaryBookAdapter
    private lateinit var mSecondaryBookAdapter: SecondaryBookAdapter

    private var mPrimaryBookDelegate = primaryBookDelegate
    private var mSecondaryBookDelegate = secondaryBookDelegate

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {

        context = viewGroup.context

        if (viewType == VT_PRIMARY_BOOK) {
            primaryView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.primary_recycler_view,
                viewGroup,
                false
            )
            mViewHolder = PrimaryBookViewHolder(primaryView)
        } else {
            secondaryView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.secondary_recycler_view,
                viewGroup,
                false
            )
            mViewHolder = SecondaryBookViewHolder(secondaryView)
        }
        return mViewHolder
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {

        if (viewHolder.itemViewType == VT_PRIMARY_BOOK) {
            setUpPrimaryBookView(viewHolder as PrimaryBookViewHolder)
            mPrimaryBookAdapter.setPrimaryBookData(mPirmaryBookData, primaryView)
        } else if (viewHolder.itemViewType == VT_SECONDARY_BOOK) {
            setUpSecondaryBookView(viewHolder as SecondaryBookViewHolder)
            mSecondaryBookAdapter.setSecondaryBookData(mSecondaryBookData, secondaryView)
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return VT_PRIMARY_BOOK
        }
        return VT_SECONDARY_BOOK
    }

    override fun getItemCount(): Int {
        return 2
    }

    private fun setUpPrimaryBookView(viewHolder: PrimaryBookViewHolder) {
        mPrimaryBookAdapter = PrimaryBookAdapter(mPrimaryBookDelegate)
        snapHelper.attachToRecyclerView(viewHolder.rvPrimaryBook)
        viewHolder.rvPrimaryBook.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewHolder.rvPrimaryBook.adapter = mPrimaryBookAdapter
    }

    private fun setUpSecondaryBookView(viewHolder: SecondaryBookViewHolder) {
        mSecondaryBookAdapter = SecondaryBookAdapter(mSecondaryBookDelegate)
        viewHolder.rvSecondaryBook.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewHolder.rvSecondaryBook.adapter = mSecondaryBookAdapter
    }

    fun setPrimaryBookData(books: List<PrimaryBookVO>) {
        mPirmaryBookData = books
        notifyDataSetChanged()
    }

    fun setSecondaryBookData(books: List<BookVO>) {
        mSecondaryBookData = books
        notifyDataSetChanged()
    }

}