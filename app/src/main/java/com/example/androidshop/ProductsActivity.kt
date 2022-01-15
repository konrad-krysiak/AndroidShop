package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshop.adapter.ProductAdapter
import com.example.androidshop.interfaces.ProductOnClickHandler

class ProductsActivity : AppCompatActivity(), ProductOnClickHandler {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var rvProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
//        Log.i("@@@@", "Prducts activity started!")

        supportFragmentManager.beginTransaction()
            .replace(R.id.flProductFragmentContainer, ProductsFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onClickHandler(view: View) {
//        Log.i("@@@@", "Item clicked!!")
        supportFragmentManager.beginTransaction()
            .replace(R.id.flProductFragmentContainer, ProductFragment())
            .addToBackStack(null)
            .commit()
    }
}