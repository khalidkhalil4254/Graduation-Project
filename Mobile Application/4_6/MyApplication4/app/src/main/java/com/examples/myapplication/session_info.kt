package com.examples.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_cp_application_form.*
import kotlinx.android.synthetic.main.activity_session_info.*
import kotlinx.android.synthetic.main.activity_speakers_voda.*


class session_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_info)


        val image = intent?.getIntExtra("image",0)
        if (image != null) {
            imgget2.setImageResource(image)
        }

        // company var globale

        var title22 = intent?.getStringExtra("title")

        Toast.makeText(this,"$title22",Toast.LENGTH_LONG).show()
        //get seats count all--------------------------------------- start
        var allSeatsUrl:String = "https://nc2mr41fz8.execute-api.us-east-1.amazonaws.com/api/v1/sessions/checkSeats"
        val queue1 = Volley.newRequestQueue(this)

        val request1 = StringRequest(
            Request.Method.GET, allSeatsUrl,
            Response.Listener { response ->
                // Handle successful response as string
                ed1.text=response.toString()

            },
            Response.ErrorListener { error ->
                // Handle error response
            })

        queue1.add(request1)


//        val company = "Vodafone \n" +
//                "session"
        val encodedCompany = Uri.encode(title22)

        //get seats count by company--------------------------------
        var getByCompanyUrl:String = "https://nc2mr41fz8.execute-api.us-east-1.amazonaws.com/api/v1/sessions/getCountByCompany?COMPANY=$encodedCompany"

        val queue = Volley.newRequestQueue(this)

        val request = StringRequest(
            Request.Method.GET, getByCompanyUrl,
            Response.Listener { response ->
                // Handle successful response as string

                ed2.text=response.toString()
                ed3.text = "100"

            },
            Response.ErrorListener { error ->
                // Handle error response
            })

        queue.add(request)



//put it in activity after this

        //get remaining seats----------------------------------------End


    }
}