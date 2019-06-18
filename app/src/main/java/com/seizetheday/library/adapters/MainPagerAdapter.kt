package com.seizetheday.library.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.seizetheday.library.fragments.BookMarkFragment
import com.seizetheday.library.fragments.CategoryFragment
import com.seizetheday.library.fragments.HomeFragment

class MainPagerAdapter(fragment: FragmentManager) : FragmentPagerAdapter(fragment) {

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

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Home"
            1 -> "Book Mark"
            else -> "Category"
        }
    }


}