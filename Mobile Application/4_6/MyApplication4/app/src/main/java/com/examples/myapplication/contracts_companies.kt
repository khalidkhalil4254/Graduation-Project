package com.examples.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class contracts_companies : AppCompatActivity() {

    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>
    private  lateinit var choices: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<company>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contracts_companies)

        imageId = arrayOf(
            R.drawable.lg ,
            R.drawable.etisalat_finish,
            R.drawable.huawei2,
            R.drawable.orange,
            R.drawable.dell_,
            R.drawable.ibm


        )

        names = arrayOf(
            "LG ",
            "Etisalat ",
            "Huawei ",
            "Orange ",
            "Dell ",
            "Ibm "

        )

        ingredients = arrayOf(
            "17/6",
            "11/6",
            "26/6",
            "10/6",
            "13/6",
            "19/6"

        )


        choices= arrayOf(
            "contracts",
            "contracts",
            "contracts",
            "contracts",
            "contracts",
            "contracts"
        )

        recView = findViewById(R.id.recView3)
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
