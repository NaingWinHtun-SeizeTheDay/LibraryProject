package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.seizetheday.library.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //login text view
        tv_register_login.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }

        //show hide password
        cb_register_show_password.setOnClickListener {
            if (cb_register_show_password.isChecked) {
                tit_register_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                tit_register_confirm_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                tit_register_password.transformationMethod = PasswordTransformationMethod.getInstance()
                tit_register_confirm_password.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }
}