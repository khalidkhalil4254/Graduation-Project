package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class SignUp_other : AppCompatActivity() {

    lateinit var button2: Button
    lateinit var editText: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var url:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_other)

        url="https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v1/auth/create"

        editText = findViewById(R.id.id_signup_other_phone)
        editText2 = findViewById(R.id.email_req_cp)
        editText3 = findViewById(R.id.password_signup_other)




        button2 = findViewById(R.id.signupBtn_signupOther)

        button2.setOnClickListener {

            if(editText.text.toString().toLong()>232142320 && editText.text.toString().toLong()<=232142330)
            {

                try{
                    // Create the request body as a JSONObject.
                    val requestBody = JSONObject()
                    requestBody.put("ID", editText.text.toString())
                    requestBody.put("USERNAME", editText2.text.toString())
                    requestBody.put("PASSWORD", editText3.text.toString())
                    requestBody.put("ROLE", "ORGANIZER")

                    // Call the sendPostRequest function with the URL and request body.

                    sendPostRequest(url, requestBody) { responseString ->

                        if(responseString=="created!"){
                            intent= Intent(this,Control::class.java)
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


            else if (editText.text.toString().toLong()>5443343 && editText.text.toString().toLong()<=5443393)
            {
                try{
                    // Create the request body as a JSONObject.
                    val requestBody = JSONObject()
                    requestBody.put("ID", editText.text.toString())
                    requestBody.put("USERNAME", editText2.text.toString())
                    requestBody.put("PASSWORD", editText3.text.toString())
                    requestBody.put("ROLE", "VODAFONE SPEAKERS")

                    // Call the sendPostRequest function with the URL and request body.

                    sendPostRequest(url, requestBody) { responseString ->

                        if(responseString=="created!"){
                            intent= Intent(this,Speakers_voda::class.java)
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
            else if (editText.text.toString().toLong()>3648232 && editText.text.toString().toLong()<=3648272)
            {

                try{
                    // Create the request body as a JSONObject.
                    val requestBody = JSONObject()
                    requestBody.put("ID", editText.text.toString())
                    requestBody.put("USERNAME", editText2.text.toString())
                    requestBody.put("PASSWORD", editText3.text.toString())
                    requestBody.put("ROLE", "IBM SPEAKERS")

                    // Call the sendPostRequest function with the URL and request body.

                    sendPostRequest(url, requestBody) { responseString ->

                        if(responseString=="created!"){
                            intent= Intent(this,Speakers_ibm::class.java)
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
            else if (editText.text.toString().toLong()>7854634 && editText.text.toString().toLong()<=7854654)
            {

                try{
                    // Create the request body as a JSONObject.
                    val requestBody = JSONObject()
                    requestBody.put("ID", editText.text.toString())
                    requestBody.put("USERNAME", editText2.text.toString())
                    requestBody.put("PASSWORD", editText3.text.toString())
                    requestBody.put("ROLE", "ETISALAT SPEAKERS")

                    // Call the sendPostRequest function with the URL and request body.

                    sendPostRequest(url, requestBody) { responseString ->

                        if(responseString=="created!"){
                            intent= Intent(this,Speakers_etisalat::class.java)
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
            else if (editText.text.toString().toLong()>983439533 && editText.text.toString().toLong()<=983439553)
            {

                try{
                    // Create the request body as a JSONObject.
                    val requestBody = JSONObject()
                    requestBody.put("ID", editText.text.toString())
                    requestBody.put("USERNAME", editText2.text.toString())
                    requestBody.put("PASSWORD", editText3.text.toString())
                    requestBody.put("ROLE", "VIP VISITORS")

                    // Call the sendPostRequest function with the URL and request body.

                    sendPostRequest(url, requestBody) { responseString ->

                        if(responseString=="created!"){
                            intent= Intent(this,VIP_visitor::class.java)
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

            else

                Toast.makeText(this, "wrong ID , try again ", Toast.LENGTH_LONG).show()
                //            string = editText.text.toString().toLong().toString()
                //            textView.text = string
        }

        button2.setEnabled(false);

        editText.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        editText3.addTextChangedListener(textWatcher);
    }



    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Do nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val n = editText.text.toString()
            val a = editText2.text.toString()
            val r = editText3.text.toString()


            if (!n.isEmpty() && !a.isEmpty() && !r.isEmpty()){
                button2.isEnabled = true
            }

       else {
                button2.isEnabled = false
            }
        }

        override fun afterTextChanged(s: Editable?) {
            // Do nothing
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
