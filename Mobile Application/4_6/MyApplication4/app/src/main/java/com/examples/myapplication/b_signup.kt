package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bsignup.other
import kotlinx.android.synthetic.main.activity_bsignup.visitor

class b_signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bsignup)

        visitor.setOnClickListener {
            intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        other.setOnClickListener {
            intent= Intent(this,SignUp_other::class.java)
            startActivity(intent)
        }
    }
}