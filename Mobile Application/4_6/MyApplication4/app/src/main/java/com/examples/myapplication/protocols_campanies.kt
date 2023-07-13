package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class protocols_campanies : AppCompatActivity() {

    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>
    private  lateinit var choices: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<company>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protocols_campanies)

        imageId = arrayOf(
            R.drawable.lg ,
            R.drawable.etisalat_finish,
            R.drawable.huawei2,
            R.drawable.orange,
            R.drawable.dell_,
            R.drawable.ibm
        )

        names = arrayOf(
            "LG protocol",
            "Etisalat ",
            "Huawei ",
            "Orange ",
            "Dell ",
            "Ibm "

        )

        ingredients = arrayOf(
            "30/6",
            "11/6",
            "22/6",
            "8/6",
            "1/6",
            "2/6"

        )


        choices= arrayOf(
            "protocols",
            "protocols",
            "protocols",
            "protocols",
            "protocols",
            "protocols"
        )


        recView = findViewById(R.id.recView4)
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
