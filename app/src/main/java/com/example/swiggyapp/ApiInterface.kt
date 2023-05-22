package com.example.swiggyapp

import com.example.swiggyapp.response.productResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("ea008c30164e5572e73c")
    fun getDate(): Call<List<productResponseItem>>
}