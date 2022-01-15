package com.example.androidshop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required
import org.bson.types.ObjectId

@RealmClass
open class Category : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    open var id: Int = 0

    @SerializedName("name")
    @Expose
    open var name: String = ""
    
//    @LinkingObjects("_category")
//    val _products: RealmResults<Product>? = null
}