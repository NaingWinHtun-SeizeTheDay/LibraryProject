package com.seizetheday.library.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.seizetheday.library.R
import com.seizetheday.library.fragments.BookMarkFragment
import com.seizetheday.library.fragments.CategoryFragment
import com.seizetheday.library.fragments.HomeFragment

class MainPagerAdapter(private val context: Context, fragment: FragmentManager) : FragmentPagerAdapter(fragment) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> BookMarkFragment()
            else -> CategoryFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    /*override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.resources.getString(R.string.text_book_title)
            1 -> context.resources.getString(R.string.text_bookmark_title)
            else -> context.resources.getString(R.string.text_category_title)
        }
    }*/

}