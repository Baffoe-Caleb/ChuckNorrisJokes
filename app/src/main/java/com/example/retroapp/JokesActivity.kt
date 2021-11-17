package com.example.retroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_jokes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class JokesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)

        getMyData() }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl(BASE_URL).build()
            .create(ApiInterface::class.java)


        //to get data
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<JokesItems>?> {
            override fun onResponse(
                call: Call<List<JokesItems>?>,
                response: Response<List<JokesItems>?>) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for(myData in responseBody){
                    myStringBuilder.append(myData.title)
                    myStringBuilder.append("\n")
                }
                txt.text = myStringBuilder
            }

            override fun onFailure(call: Call<List<JokesItems>?>, t: Throwable) {
                Log.d("JokesActivity", "onFailure: "+t.message)

            }
        })

    }

}