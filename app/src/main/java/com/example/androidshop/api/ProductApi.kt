package com.example.androidshop.api

import com.example.androidshop.MainActivity
import com.example.androidshop.models.response._Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductApi {
    @GET("products")
    @Headers("Content-Type: application/json")
    fun getProducts() : Call<List<_Product>>

    companion object {
        fun create() : ProductApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MainActivity.URL)
                .build()
            return retrofit.create(ProductApi::class.java)
        }

    }
}