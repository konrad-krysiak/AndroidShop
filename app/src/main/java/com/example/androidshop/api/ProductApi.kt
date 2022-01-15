package com.example.androidshop.api

import com.example.androidshop.models.Product
import com.example.androidshop.utils.Connection
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductApi {
    @GET("products")
    @Headers("Content-Type: application/json")
    fun getProducts() : Observable<List<Product>>

    companion object {
        fun create() : ProductApi {
            return Connection().retrofit.create(ProductApi::class.java)
        }

    }
}