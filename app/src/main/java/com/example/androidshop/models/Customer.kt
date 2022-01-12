package com.example.androidshop.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class Customer : RealmObject() {
    @PrimaryKey var _id: ObjectId = ObjectId()
    @Required var name: String? = ""
    @Required var surname: String? = ""
    var email: String = ""
    var _orders: RealmList<Order>? = null
}