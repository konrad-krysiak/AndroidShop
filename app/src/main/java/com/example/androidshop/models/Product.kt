package com.example.androidshop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Product : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    open var id: Int = 0

    @SerializedName("name")
    @Expose
    open var name: String? = ""

    @SerializedName("price")
    @Expose
    open var price: Double = 0.0

    @SerializedName("category_id")
    @Expose
    var category_id: Int? = null

    override fun toString(): String {
        return "Product(id:${id}, name=${name}, price=${price}, category_id=${category_id}"
    }
}