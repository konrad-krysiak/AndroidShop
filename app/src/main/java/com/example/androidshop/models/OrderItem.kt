package com.example.androidshop.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class OrderItem : RealmObject() {
    var _product: Product? = null
    var amount: Int = 0
}