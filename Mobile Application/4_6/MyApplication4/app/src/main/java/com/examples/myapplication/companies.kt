package com.examples.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class companies : AppCompatActivity() {
    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>
    private  lateinit var choices: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<company>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companies)

        imageId = arrayOf(
            R.drawable.lg ,
            R.drawable.etisalat_finish,
            R.drawable.huawei2,
            R.drawable.orange,
            R.drawable.dell_,
            R.drawable.ibm


        )

        names = arrayOf(
            "LG event",
            "Etisalat event",
            "Huawei event",
            "Orange event",
            "Dell event",
            "Ibm event"

        )

        ingredients = arrayOf(
            "12/6",
            "11/6",
            "20/6",
            "14/6",
            "16/6",
            "15/6"

        )

        choices= arrayOf(
            "events",
            "events",
            "events",
            "events",
            "events",
            "events"
        )


        recView = findViewById(R.id.recView)
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