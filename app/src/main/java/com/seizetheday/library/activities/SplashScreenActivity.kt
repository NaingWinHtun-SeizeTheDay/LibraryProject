package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.seizetheday.library.R

class SplashScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, 300)
    }
}