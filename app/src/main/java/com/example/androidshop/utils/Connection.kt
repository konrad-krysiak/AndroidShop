package com.example.androidshop.utils

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import io.realm.RealmObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Connection {
    var URL = "http://1f50-195-150-224-31.ngrok.io"
    val gson = GsonBuilder().setExclusionStrategies(object: ExclusionStrategy {
        override fun shouldSkipField(f: FieldAttributes?): Boolean {
            return f!!.declaringClass == RealmObject::class.java
        }
        override fun shouldSkipClass(clazz: Class<*>?): Boolean {
            return false
        }
    }).create()
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(URL)
        .build()
}