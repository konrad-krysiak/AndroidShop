package com.example.androidshop.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class Product : RealmObject() {
    @PrimaryKey var _id: ObjectId = ObjectId()
    @Required var name: String? = ""
    var price: Double = 0.0
    var _category: Category? = null
}