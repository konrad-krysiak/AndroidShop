package com.example.androidshop.models.response;

import com.google.gson.annotations.SerializedName

data class _Product(
    @SerializedName("id") var id: Int,
    @SerializedName("name")var name: String,
    @SerializedName("price") var price: Double,
    @SerializedName("category_id") var category_id: Int
    )