package com.examples.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_speakers_voda.*

class Speakers_voda : AppCompatActivity() {

    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<company>
    private  lateinit var choices: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speakers_voda)

        imageId = arrayOf(

            R.drawable.voda_1,



        )

        names = arrayOf(

            "Vodafone \nsession"


        )

        ingredients = arrayOf(

            "20/6"


        )

        choices= arrayOf(
            "speaker",
        )


        recView = findViewById(R.id.recView9)
        // the type of the recyclerView. linear or grid
        recView.layoutManager = GridLayoutManager(this,2)
        recView.setHasFixedSize(true)
        itemArrayList = arrayListOf()
        getData()
        recView.adapter = RecAadapter(itemArrayList)


        //get seats count all--------------------------------------- start
//        var allSeatsUrl:String = "https://nc2mr41fz8.execute-api.us-east-1.amazonaws.com/api/v1/sessions/checkSeats"
//        val queue1 = Volley.newRequestQueue(this)
//
//        val request1 = StringRequest(Request.Method.GET, allSeatsUrl,
//            Response.Listener { response ->
//                // Handle successful response as string
//                ed1.text=response.toString()
//
//            },
//            Response.ErrorListener { error ->
//                // Handle error response
//            })
//
//        queue1.add(request1)
//
//
//        val company = "Vodafone \n" +
//                "session"
//        val encodedCompany = Uri.encode(company)
//
//        //get seats count by company--------------------------------
//        var getByCompanyUrl:String = "https://nc2mr41fz8.execute-api.us-east-1.amazonaws.com/api/v1/sessions/getCountByCompany?COMPANY=$encodedCompany"
//
//        val queue = Volley.newRequestQueue(this)
//
//        val request = StringRequest(Request.Method.GET, getByCompanyUrl,
//            Response.Listener { response ->
//                // Handle successful response as string
//
//                ed2.text=response.toString()
//                ed3.text = "50"
//
//            },
//            Response.ErrorListener { error ->
//                // Handle error response
//            })
//
//        queue.add(request)



//put it in activity after this

        //get remaining seats----------------------------------------End







    }

    private fun getData() {

        for (i in imageId.indices) {
            val company = company(imageId[i], names[i], ingredients[i],choices[i])
            itemArrayList.add(company)
        }

    }
}