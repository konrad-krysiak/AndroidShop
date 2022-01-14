package com.example.androidshop.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshop.R
import com.example.androidshop.interfaces.ProductOnClickHandler
import com.example.androidshop.models.response._Product

class ProductAdapter(
    private var products: List<_Product>,
    context: Context
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private val clickHandler: ProductOnClickHandler = context as ProductOnClickHandler

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val price: TextView = itemView.findViewById(R.id.tvPrice)
        val quantity: EditText = itemView.findViewById(R.id.etQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view).also {
            view.setOnClickListener{ clickHandler.onClickHandler(it) }
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentTodo = products[position]
        holder.title.text = currentTodo.name
        holder.price.text = currentTodo.price.toString()
        holder.quantity.setText("0")
    }

    override fun getItemCount(): Int {
        return products.size
    }
}