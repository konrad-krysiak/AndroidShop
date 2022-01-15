package com.example.androidshop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshop.adapter.ProductAdapter
import com.example.androidshop.api.ProductApi
import com.example.androidshop.models.Category
import com.example.androidshop.models.Product
import io.reactivex.rxjava3.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsFragment : Fragment() {
    private lateinit var rvProducts: RecyclerView
    private lateinit var realm: Realm
    private lateinit var list: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            list = it.where(Product::class.java).findAll()
        }

        rvProducts = view.findViewById(R.id.rvProducts)
        rvProducts.adapter = ProductAdapter(list, requireContext())
        rvProducts.layoutManager = LinearLayoutManager(requireContext())

        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            requireActivity().finish()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}