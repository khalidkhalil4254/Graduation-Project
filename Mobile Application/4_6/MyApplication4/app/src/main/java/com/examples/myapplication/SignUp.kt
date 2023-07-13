package com.examples.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject


class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        loginButton.setOnClickListener{
            try{
// Create the request body as a JSONObject.
                val requestBody = JSONObject()
                requestBody.put("USERNAME", email_req_cp.text.toString())
                requestBody.put("PASSWORD", password_signup_other.text.toString())
                requestBody.put("PHONE", id_signup_other_phone.text.toString())
                requestBody.put("ROLE", "VISITOR")

                Toast.makeText(this,"user: ${email_req_cp.text.toString()}, pass: ${password_signup_other.text.toString()}, phone: ${id_signup_other_phone.text.toString()}",Toast.LENGTH_LONG).show()

// Call the sendPostRequest function with the URL and request body.
                val url = "https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v0/auth/create"

                sendPostRequest(url, requestBody) { responseString ->

                    if(responseString=="created!"){
                        intent= Intent(this,Home_page::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Invalid Input Data! Please Try Again!",Toast.LENGTH_LONG).show()
                    }

                    // Handle the response string here
                    Log.d("Response", responseString)
                }

            }catch(err:Exception){
                Toast.makeText(this,"Error:${err}",Toast.LENGTH_LONG).show()
            }


        }


        log_btn1.setOnClickListener {
            intent= Intent(this,Login::class.java)
            startActivity(intent)
        }
    }


    private fun sendPostRequest(url: String, requestBody: JSONObject, result: (String) -> Unit) {

        val requestQueue = Volley.newRequestQueue(this)

        val jsonObjectRequest = object : JsonObjectRequest(
            Method.POST,
            url,
            requestBody,
            Response.Listener { response ->
                // Handle the response here
                Log.d("Response", response.toString())
                Toast.makeText(this,"Response: ${response.get("message")}",Toast.LENGTH_LONG).show()
                val responseString = response.get("message").toString()
                result(responseString)
            },
            Response.ErrorListener { error ->
                // Handle error here
                Log.e("Error", error.toString())
                Toast.makeText(this,"Error: ${error.message}",Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                // Set the Content-Type header to application/json
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }

        requestQueue.add(jsonObjectRequest)
    }


}