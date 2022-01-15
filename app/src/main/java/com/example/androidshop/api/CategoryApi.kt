package com.example.androidshop.api

import com.example.androidshop.models.Category
import com.example.androidshop.utils.Connection
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface CategoryApi {
    @GET("products")
    @Headers("Content-Type: application/json")
    fun getCategories() : Observable<List<Category>>

    companion object {
        fun create() : CategoryApi {
            return Connection().retrofit.create(CategoryApi::class.java)
        }

    }
}