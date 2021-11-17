package com.example.retroapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("todos")
    fun getData():Call<List<JokesItems>>
}