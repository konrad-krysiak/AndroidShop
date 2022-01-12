package com.example.androidshop.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class Category : RealmObject() {
    @PrimaryKey var _id: ObjectId = ObjectId()
    @Required var name: String = ""
    @LinkingObjects("_category")
    val _products: RealmResults<Product>? = null
}