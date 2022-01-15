package com.example.androidshop.models

import com.example.androidshop.interfaces.OrderInterface
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class Order : RealmObject(), OrderInterface {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var orderItems: RealmList<OrderItem>? = null
    @LinkingObjects("_orders")
    val customer: RealmResults<Customer>? = null


    override fun addToOrder(realm: Realm, product: Product, amount: Int) {
        realm.executeTransactionAsync { r : Realm ->
            val item = r.createObject(OrderItem::class.java)
            item._product = product
            item.amount = amount
            this.orderItems!!.add(item)
        }
    }

    override fun removeFromOrder(realm: Realm, product: Product) {
        realm.executeTransactionAsync { r: Realm ->
            var item = realm.where(OrderItem::class.java)
                .equalTo("_product._id", product.id)
                .findFirst()
            this.orderItems!!.remove(item)
        }
    }

    fun getcustomer(): RealmResults<Customer>? {
        return this.customer
    }

    fun getitems() : RealmList<OrderItem>? {
        return this.orderItems
    }
}