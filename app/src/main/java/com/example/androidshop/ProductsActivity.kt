package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshop.adapter.ProductAdapter
import com.example.androidshop.interfaces.ProductOnClickHandler
import com.example.androidshop.models.Category
import com.example.androidshop.models.Product
import io.realm.Realm

class ProductsActivity : AppCompatActivity(), ProductOnClickHandler {
    private lateinit var realm: Realm

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
        val pos = view.tag as Int
        realm = Realm.getDefaultInstance()
        var result: Product? = null
        var category: Category? = null
        realm.executeTransaction {
            result = it.where(Product::class.java).findAll()[pos]
            category = it.where(Category::class.java).containsValue("id", result?.category_id).findFirst()
        }
        val product = ProductFragment.newInstance(
            result?.name!!,
            result?.id.toString(),
            category?.name!!,
            result?.price.toString(),
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.flProductFragmentContainer, product)
            .addToBackStack(null)
            .commit()
    }
}