package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.seizetheday.library.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //show hide password
        cb_login_show_password.setOnClickListener {
            if (cb_login_show_password.isChecked) {
                tit_login_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                tit_login_password.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        //login text
        tv_login_register.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()
        }
    }
}
