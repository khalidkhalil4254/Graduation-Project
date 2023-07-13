package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_started.l_btn
import kotlinx.android.synthetic.main.activity_get_started.s_btn

class Get_started : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        s_btn.setOnClickListener {
            intent= Intent(this,b_signup::class.java)
            startActivity(intent)
        }
        l_btn.setOnClickListener {
            intent= Intent(this,Login::class.java)
            startActivity(intent)
        }
    }
}