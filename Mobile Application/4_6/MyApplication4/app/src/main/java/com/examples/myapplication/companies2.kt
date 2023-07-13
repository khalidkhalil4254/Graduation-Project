package com.examples.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class companies2 : AppCompatActivity() {
    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<company>
        private  lateinit var choices: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companies2)

        imageId = arrayOf(
            R.drawable.lenovo ,
            R.drawable.etisalat_finish,
            R.drawable.huawei2,
            R.drawable.voda_1,
            R.drawable.samsong_1,
            R.drawable.ibm


        )

        names = arrayOf(
            "Lenovo \nsession",
            "Etisalat \nsession",
            "Huawei \nsession",
            "Vodafone \nsession",
            "Samsong \nsession",
            "Ibm session"

        )

        ingredients = arrayOf(
            "13/6",
            "14/6",
            "26/6",
            "11/6",
            "12/6",
            "15/6"

        )


        choices= arrayOf(
            "sessions",
            "sessions",
            "sessions",
            "sessions",
            "sessions",
            "sessions"
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