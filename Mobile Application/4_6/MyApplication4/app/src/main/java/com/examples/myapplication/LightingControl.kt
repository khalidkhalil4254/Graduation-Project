package com.examples.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_lighting_control.*

class LightingControl : AppCompatActivity() {
    var ip_address="192.168.1.9"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lighting_control)



        LEDS_ALL_ON.setOnClickListener{
            manipulateAllLEDs(1)
        }



        LEDS_ALL_OFF.setOnClickListener{
            manipulateAllLEDs(0)
        }



//--------------------------------------------------------------------------------------------------
        LED_1_ON.setOnClickListener{
            manipulateLED("field1",1)
        }



        LED_1_OFF.setOnClickListener{
            manipulateLED("field1",0)
        }




//--------------------------------------------------------------------------------------------------
        LED_2_ON.setOnClickListener{
            manipulateLED("field2",1)
        }



        LED_2_OFF.setOnClickListener{
            manipulateLED("field2",0)
        }



//--------------------------------------------------------------------------------------------------
        LED_3_ON.setOnClickListener{
            manipulateLED("field3",1)
        }



        LED_3_OFF.setOnClickListener{
            manipulateLED("field3",0)
        }





//------------------------------------------------------------------------------------------------
        LED_4_ON.setOnClickListener{
            manipulateLED("field4",1)
        }



        LED_4_OFF.setOnClickListener{
            manipulateLED("field4",0)
        }



//--------------------------------------------------------------------------------------------------
        LED_5_ON.setOnClickListener{
            manipulateLED("field5",1)
        }



        LED_5_OFF.setOnClickListener{
            manipulateLED("field5",0)
        }

    }







    private fun manipulateLED(LED:String, mode:Int){

        // getting a new volley request
        // queue for making new requests
        val volleyQueue = Volley.newRequestQueue(this)

        // url of the api through which we get random dog images
        val url = "https://api.thingspeak.com/update?api_key=LALUGQNR8489ED1Z&${LED}=${mode.toString()}"

        // since the response we get from the api is in JSON,
        // we need to use `JsonObjectRequest` for
        // parsing the request response
        val stringrequest = StringRequest(
            // we are using GET HTTP request method
            Request.Method.GET,
            // url we want to send the HTTP request to
            url,
            // lambda function for handling the case
            // when the HTTP request succeeds
            { response ->
                // get the image url from the JSON object
                Toast.makeText(this,"Response: ${response.toString()}",Toast.LENGTH_LONG).show()

            },

            // lambda function for handling the
            // case when the HTTP request fails
            { error ->
                // make a Toast telling the user
                // that something went wrong
                Toast.makeText(this, "Error Manipulating a LED: ${error.localizedMessage}", Toast.LENGTH_LONG).show()
                // log the error message in the error stream
                Log.e("MainActivity", "Error Manipulating a LED: ${error.localizedMessage}")
            }
        )

        // add the json request object created
        // above to the Volley request queue
        volleyQueue.add(stringrequest)
    }





    private fun manipulateAllLEDs(mode:Int){

        // getting a new volley request
        // queue for making new requests
        val volleyQueue = Volley.newRequestQueue(this)

        // url of the api through which we get random dog images
        val url = "https://api.thingspeak.com/update?api_key=LALUGQNR8489ED1Z&field1=${mode}&field2=${mode}&field3=${mode}&field4=${mode}&field5=${mode}"

        // since the response we get from the api is in JSON,
        // we need to use `JsonObjectRequest` for
        // parsing the request response
        val stringRequest  = StringRequest(
            // we are using GET HTTP request method
            Request.Method.GET,
            // url we want to send the HTTP request to
            url,

            // lambda function for handling the case
            // when the HTTP request succeeds
            { response ->
                // get the image url from the JSON object
                Toast.makeText(this,"Response: ${response.toString()}",Toast.LENGTH_LONG).show()

            },

            // lambda function for handling the
            // case when the HTTP request fails
            { error ->
                // make a Toast telling the user
                // that something went wrong
                Toast.makeText(this, "Error Manipulating a LED: ${error.localizedMessage}", Toast.LENGTH_LONG).show()
                // log the error message in the error stream
                Log.e("MainActivity", "Error Manipulating a LED: ${error.localizedMessage}")
            }
        )

        // add the json request object created
        // above to the Volley request queue
        volleyQueue.add(stringRequest)
    }



}