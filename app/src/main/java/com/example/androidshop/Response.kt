package com.example.androidshop

import com.google.gson.annotations.SerializedName

class CustomerResponse {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("surname")
    var surname: String? = null
    @SerializedName("email")
    var email: String? = null
}

class OrderResponse {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("customer_id")
    var customer_id: Int = 0
}