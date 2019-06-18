package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.seizetheday.library.R
import com.seizetheday.library.adapters.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_main.adapter = MainPagerAdapter(supportFragmentManager)
        tl_main.setupWithViewPager(vp_main)

        //click to profile activity
        iv_profile_main.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
        }

    }
}