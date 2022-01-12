package com.example.androidshop.utils

import com.example.androidshop.MainFragment
import com.example.androidshop.api.ProductApi
import com.example.androidshop.models.response._Product
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class init {

    fun getProducts() : List<_Product>? {
        var products: List<_Product>? = null
        try {
             products = ProductApi.create().getProducts().execute().body()
        } catch(t: Throwable) {
            t.printStackTrace()
        }
        return products
    }
}