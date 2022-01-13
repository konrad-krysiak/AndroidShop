package com.example.androidshop.models

import com.example.androidshop.api.ProductApi
import com.example.androidshop.models.response._Product
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import kotlinx.coroutines.runBlocking
import org.bson.types.ObjectId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Product : RealmObject() {
    @PrimaryKey var _id: ObjectId = ObjectId()
    @Required var name: String? = ""
    var price: Double = 0.0
    var _category: Category? = null
}