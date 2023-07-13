package com.examples.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Speakers_ibm : AppCompatActivity() {

    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<company>
    private  lateinit var choices: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speakers_ibm)

        imageId = arrayOf(

            R.drawable.ibm


        )

        names = arrayOf(

            "Ibm session"

        )

        ingredients = arrayOf(

            "15/6"

        )

        choices= arrayOf(
            "speaker",
        )


        recView = findViewById(R.id.recView5)
        // the type of the recyclerView. linear or grid
        recView.layoutManager = GridLayoutManager(this,2)

        recView.setHasFixedSize(true)


        itemArrayList = arrayListOf()

        getData()

        recView.adapter = RecAadapter(itemArrayList)


    }

    private fun getData() {

        for (i in imageId.indices) {
            val company = company(imageId[i], names[i], ingredients[i],choices[i])
            itemArrayList.add(company)
        }

    }
}