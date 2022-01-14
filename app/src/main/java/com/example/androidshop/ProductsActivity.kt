package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.resources.Compatibility
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshop.adapter.ProductAdapter
import com.example.androidshop.api.ProductApi
import com.example.androidshop.interfaces.ProductOnClickHandler
import com.example.androidshop.models.Product
import com.example.androidshop.models.response._Product
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity(), ProductOnClickHandler {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var rvProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)


        ProductApi.create().getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe({ list ->
                Log.i("@@@@", list.toString())
                rvProducts = findViewById(R.id.rvProducts)
                rvProducts.adapter = ProductAdapter(list, this)
                rvProducts.layoutManager = LinearLayoutManager(this)
            }, { e ->
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            })




        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            this.finish()
        }
    }

    override fun onClickHandler(view: View) {
        Log.i("@@@@", "Item clicked!!")
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, ProductFragment())
            .addToBackStack(null)
            .commit()
    }
}