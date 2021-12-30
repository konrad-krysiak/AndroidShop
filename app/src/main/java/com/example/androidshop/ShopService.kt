package com.example.androidshop

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopService {
    @GET("/customers/")
    fun getCustomers(): Call<CustomerResponse>

    @GET("/orders/{customer_id}")
    fun getOrderByCustomerId(@Query("customer_id") customer_id: String): Call<OrderResponse>
}