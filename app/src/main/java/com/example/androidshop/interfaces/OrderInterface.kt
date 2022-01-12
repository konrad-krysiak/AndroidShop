package com.example.androidshop.interfaces

import com.example.androidshop.models.Product
import io.realm.Realm

interface OrderInterface {
    fun addToOrder(realm: Realm, product: Product, amount: Int) : Unit
    fun removeFromOrder(realm: Realm, product: Product) : Unit
}