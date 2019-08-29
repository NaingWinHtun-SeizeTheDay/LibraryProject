package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import com.seizetheday.library.R
import com.seizetheday.library.adapters.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        vp_main.adapter = MainPagerAdapter(this, supportFragmentManager)
        tl_main.setupWithViewPager(vp_main)

        tl_main.getTabAt(0)?.setIcon(R.drawable.ic_home_black_24dp)
        tl_main.getTabAt(1)?.setIcon(R.drawable.ic_bookmark_black_24dp)
        tl_main.getTabAt(2)?.setIcon(R.drawable.ic_view_week_black_24dp)

        //click to profile activity
        iv_profile_main.setOnClickListener {
            startActivity(Intent(this@MainActivity, InfoActivity::class.java))
        }

        //click to search activity
        iv_search_activity.setOnClickListener {
            startActivity(Intent(this@MainActivity, SearchActivity::class.java))
        }
    }
}