package com.examples.myapplication


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import org.json.JSONObject

class QRcode_gen : AppCompatActivity() {

    private lateinit var ivQRcode: ImageView
    private lateinit var etData: EditText
    private lateinit var btnGenerateQRcode : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_gen)

        //getting values:
        ivQRcode = findViewById(R.id. ivQRCode)
        btnGenerateQRcode = findViewById(R.id.btnGenerateQRcode)


        //put and get extra

        var company = intent.getStringExtra("car")
        var Email_Address = intent.getStringExtra("email_Add")



        Toast.makeText(this, "emaol :  $Email_Address ", Toast.LENGTH_LONG).show()

        // return the company name


        //val message = intent.getStringExtra("myKey")


        btnGenerateQRcode.setOnClickListener {

            //------------------------------Num of seats checking--------------------

            val requestQueue = Volley.newRequestQueue(this)

            val stringRequest = StringRequest(Request.Method.GET, "https://nc2mr41fz8.execute-api.us-east-1.amazonaws.com/api/v1/sessions/checkSeats",
                { response ->
                    // Handle successful response


                    //checking the number then register:
                    if(response.toInt()<100){



                        //------------------------------QRCODE generation(Getting ID By Email)----------------------------(getExtras HERE -->EMAIL)
                        val url = "https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v1/auth/getIdByEmail?EMAIL=${Email_Address}"  // Replace with the URL you want to make a request to

                        val requestQueue = Volley.newRequestQueue(this)

                        val stringRequest = StringRequest(
                            Request.Method.GET, url,
                            { response ->

                                Toast.makeText(this,"ID: $response",Toast.LENGTH_LONG).show()

                                /////////////////////////////////////////////////////////2- if the ID in Ranges:///////////////////////////////////////////////////////
                                if(response.toInt() !in (232142320..232142330) && response.toInt() !in (5443343..5443393) && response.toInt() !in (3648232..3648272) && response.toInt() !in (7854634..7854654) && response.toInt() !in (983439533..983439553) && response!=null && response!="")
                                {




                                    //------------------------------Registeration request--------------------
                                    var jsonObj: JSONObject=JSONObject()
//                                                     (getExtras HERE -->EMAIL)
                                    jsonObj.put("KEY", Email_Address+company)
//                                                     (getExtras HERE -->EMAIL)
                                    jsonObj.put("EMAIL",Email_Address)
                                    jsonObj.put("COMPANY", company)

                                    //---------------------registering new User----------------------
                                    sendPostRequest("https://nc2mr41fz8.execute-api.us-east-1.amazonaws.com/api/v1/sessions/registerationCreate",jsonObj){ res->
                                        if(res=="ok!"){
                                            Toast.makeText(this,"You Have Registered Successfully!",Toast.LENGTH_LONG).show()
                                        }
                                        else{
                                            Toast.makeText(this,"You Have Already Registered in This Event!",Toast.LENGTH_LONG).show()
                                        }

                                    }






                                    Toast.makeText(this,"UserID: ${response}",Toast.LENGTH_LONG).show()
                                    //setting the value of the QRCODE:

                                    val data = response.trim()

                                    //validating the QRCODE:
                                    if(data.isEmpty())
                                    {
                                        Toast.makeText(this, "enter some data ", Toast.LENGTH_SHORT).show()

                                    }
                                    else{
                                        val writer = QRCodeWriter()
                                        try{
                                            val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE,  512,  512)
                                            val width = bitMatrix.width
                                            val height = bitMatrix.height
                                            val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                                            for (x in 0 until width) {
                                                for (y in 0 until height) {
                                                    bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.rgb(79,42,145) else Color.WHITE)
                                                }}
                                            ivQRcode.setImageBitmap(bmp)
                                        }catch (e:WriterException){
                                            e.printStackTrace()
                                        }
                                    }






                                }else{
                                    Toast.makeText(this,"Invalid EMAIL Address!",Toast.LENGTH_LONG).show()
                                }

                                // Handle successful response
                                Log.d("Response", response)
                            },
                            { error ->
                                Toast.makeText(this,"Email Not Found!",Toast.LENGTH_LONG).show()
                                // Handle error
                                Log.e("Error", error.toString())
                            })

                        requestQueue.add(stringRequest)





                    }else{

                        Toast.makeText(this,"Unfortunately All seats Consumed!",Toast.LENGTH_LONG).show()
                    }






                    Log.d("Response", response)
                },
                { error ->
                    // Handle error
                    Log.e("Error", error.toString())
                })

            requestQueue.add(stringRequest)





            //------------------------------QRCODE generation--------------------

//            val url = "https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v1/auth/getIdByEmail?EMAIL=${etData.text.toString()}"  // Replace with the URL you want to make a request to
//
//            val requestQueue = Volley.newRequestQueue(this)
//
//            val stringRequest = StringRequest(
//                Request.Method.GET, url,
//                { response ->
//
//
//                    /////////////////////////////////////////////////////////2- if the ID in Ranges:///////////////////////////////////////////////////////
//                    if(response.toInt() !in (232142320..232142330) && response.toInt() !in (5443343..5443393) && response.toInt() !in (3648232..3648272) && response.toInt() !in (7854634..7854654) && response.toInt() !in (983439533..983439553) && response!=null && response!=""){
//
//                        //setting the value of the QRCODE:
//                        val data=response.trim()
//
//                        //validating the QRCODE:
//                        if(data.isEmpty())
//                        {
//                            Toast.makeText(this, "enter some data ", Toast.LENGTH_SHORT).show()
//
//                        }
//                        else{
//                            val writer = QRCodeWriter()
//                            try{
//                                val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE,  512,  512)
//                                val width = bitMatrix.width
//                                val height = bitMatrix.height
//                                val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
//                                for (x in 0 until width) {
//                                    for (y in 0 until height) {
//                                        bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.rgb(79,42,145) else Color.WHITE)
//                                    }}
//                                ivQRcode.setImageBitmap(bmp)
//                            }catch (e:WriterException){
//                                e.printStackTrace()
//                            }
//                        }
//                }else{
//                    Toast.makeText(this,"Invalid EMAIL Address!",Toast.LENGTH_LONG).show()
//                }
//
//                    // Handle successful response
//                    Log.d("Response", response)
//                },
//                { error ->
//                    // Handle error
//                    Log.e("Error", error.toString())
//                })
//
//            requestQueue.add(stringRequest)

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

                Toast.makeText(this,"You Have Already Registered in This Event!",Toast.LENGTH_LONG).show()

//                Toast.makeText(this,"Error: ${error.message}",Toast.LENGTH_LONG).show()
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