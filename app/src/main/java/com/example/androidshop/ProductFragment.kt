package com.example.androidshop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var id: String? = null
    private var price: String? = null
    private var category: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString("title")
            id = it.getString("id")
            price = it.getString("price")
            category = it.getString("category")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)
        Log.i("@@@@", "Product fragment started!")

        view.findViewById<TextView>(R.id.tvTitle).text = title
        view.findViewById<TextView>(R.id.tvId).text = id
        view.findViewById<TextView>(R.id.tvPrice).text = price
        view.findViewById<TextView>(R.id.tvCategory).text = category

        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            activity?.onBackPressed()
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("@@@@", "FRAGMENT PRODUCT DESTROYED")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(title: String, id: String, category: String, price: String) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString("title", title)
                    putString("id", id)
                    putString("category", category)
                    putString("price", price)
                }
            }
    }
}