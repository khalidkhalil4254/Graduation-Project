package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_booking.book_now

class booking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)





        val img_second = findViewById<ImageView>(R.id.img_second)
        val tv_title_second = findViewById<TextView>(R.id.tv_title_secondActivity)
        val tv_ing_second = findViewById<TextView>(R.id.tv_ing_secondActivity)

        val intent = intent
        var intent2  = intent


        val image = intent?.getIntExtra("image",0)
        var title = intent?.getStringExtra("title")
        //intent.putExtra("title",title)
        val ingredients = intent?.getStringExtra("ingredients")


        Toast.makeText(this,"title: ${title}", Toast.LENGTH_LONG).show()



       // intent.putExtra("title",title)


        if (image != null) {
            img_second.setImageResource(image)
        }

        tv_title_second.text = title
        tv_ing_second.text = ingredients

        book_now.setOnClickListener {
            intent2 = Intent(this, Register_Form::class.java)
            intent2.putExtra("title",title)
            startActivity(intent2)
        }

    }
}