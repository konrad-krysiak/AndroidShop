package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            this.finish()

        }
    }
}