package com.examples.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.airbnb.lottie.parser.IntegerParser
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.password_signup_other

class Login : AppCompatActivity() {

    lateinit var getIdUrl:String
    lateinit var readAuthMobileUrl:String
    lateinit var Id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Id=""



        logbtn.setOnClickListener{
            getIdUrl="https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v1/auth/getIdByUserAndPassword?USERNAME=${email_txt_login.text.toString()}&PASSWORD=${password_signup_other.text.toString()}"
            //1- getting UserID:
            try{
                val volleyQueue = Volley.newRequestQueue(this)

                val stringRequest = StringRequest(Request.Method.GET, getIdUrl,
                    Response.Listener<String> { response ->
                        // Handle the response string
                        Id = response
                        /////////////////////////////////////////////////////////2- if the ID in Ranges:///////////////////////////////////////////////////////
                        if(Id.toLong() in (232142320..232142330)){
                            intent= Intent(this,Control::class.java)
                            startActivity(intent)
                        }else if(Id.toInt() in (5443343..5443393)){
                            intent= Intent(this,Speakers_voda::class.java)
                            startActivity(intent)
                        }else if(Id.toInt() in (3648232..3648272)){
                            intent= Intent(this,Speakers_ibm::class.java)
                            startActivity(intent)
                        }else if(Id.toInt() in (7854634..7854654)){
                            intent= Intent(this,Speakers_etisalat::class.java)
                            startActivity(intent)
                        }else if(Id.toInt() in (983439533..983439553)){
                            intent= Intent(this,VIP_visitor::class.java)
                            startActivity(intent)
                        }

                        /////////////////////////////////////////////////////////3- else if ID is not in ranges but in DB:///////////////////////////////////////////////////////
                        else if(Id.toInt() !in (232142320..232142330) && Id.toInt() !in (5443343..5443393) && Id.toInt() !in (3648232..3648272) && Id.toInt() !in (7854634..7854654) && Id.toInt() !in (983439533..983439553) && Id!=null && Id!=""){
                            intent= Intent(this, Home_page::class.java)
                            startActivity(intent)
                        }

                        /////////////////////////////////////////////////////////4- else(not found):///////////////////////////////////////////////////////
                        else{
                            Toast.makeText(this,"Invalid Username or Password!",Toast.LENGTH_LONG).show()
                        }
                    },
                    Response.ErrorListener { error ->
                        // Handle the error
                        Toast.makeText(this,"Error getting ID: ${error.message}",Toast.LENGTH_LONG).show()
                    })

// Add the string request to the request queue
                Volley.newRequestQueue(this).add(stringRequest)

            }catch(err:Exception){
                //error during requesting:
                Toast.makeText(this,"Error:${err}",Toast.LENGTH_LONG).show()
            }

        }






    }





}