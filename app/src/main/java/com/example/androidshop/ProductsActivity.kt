package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.resources.Compatibility
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshop.adapter.ProductAdapter
import com.example.androidshop.api.ProductApi
import com.example.androidshop.models.Product
import com.example.androidshop.models.response._Product
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var rvProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)


        ProductApi.create().getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe() { list ->
                rvProducts = findViewById(R.id.rvProducts)
                rvProducts.adapter = ProductAdapter(list)
                rvProducts.layoutManager = LinearLayoutManager(this)
            }




        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            this.finish()
        }
    }
}