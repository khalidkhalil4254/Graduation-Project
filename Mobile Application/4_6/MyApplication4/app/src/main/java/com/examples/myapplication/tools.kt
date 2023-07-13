package com.examples.myapplication


import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class tools : AppCompatActivity() {


    // function for making a HTTP request using
    // Volley and inserting the image in the
    // ImageView using Glide library.
    public fun loadData(url: String, data: JSONObject): String {

         var res: String ="";

        // getting a new volley request queue for making new requests
        val volleyQueue = Volley.newRequestQueue(this)

//        // create a JSON object containing the data to send
//        val jsonData = JSONObject()
//        jsonData.put("key", data)
//        jsonData.put("key", data)
//        jsonData.put("key", data)
//        jsonData.put("key", data)

        // create a JSON request object using POST method
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.GET,
            url,
            data,
            { response ->
                // handle the response as needed
                res=response.toString();
            },
            { error ->
                // handle the error as needed
                Toast.makeText(this,"$error",Toast.LENGTH_LONG).show()
            }
        ) {
            // override getHeaders() to set request headers if needed
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }

        // add the JSON request object to the Volley request queue
        volleyQueue.add(jsonObjectRequest)

        return res;
    }







    public fun sendData(url: String, data: JSONObject): String {

        var res: String = ""

        // getting a new volley request queue for making new requests
        val volleyQueue = Volley.newRequestQueue(this)

        // create a JSON request object using POST method
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.POST, // Use POST method instead of GET
            url, // Update the URL to the API endpoint that accepts POST requests
            data,
            { response ->
                // handle the response as needed
                res = response.toString()
            },
            { error ->
                // handle the error as needed
                Toast.makeText(this,"$error",Toast.LENGTH_LONG).show()
            }
        ) {
            // override getHeaders() to set request headers if needed
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }

        // add the JSON request object to the Volley request queue
        volleyQueue.add(jsonObjectRequest)

        return res
    }




}