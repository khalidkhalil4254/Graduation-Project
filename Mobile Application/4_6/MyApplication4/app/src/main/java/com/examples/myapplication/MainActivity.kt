package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.ff

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)

    }
        ff.setOnClickListener {
            intent =Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
}}