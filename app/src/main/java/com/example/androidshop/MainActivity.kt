package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidshop.adapter.ProductAdapter
import com.example.androidshop.api.CategoryApi
import com.example.androidshop.api.ProductApi
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject

class MainActivity : AppCompatActivity() {
    var TAG: String = "@@@@@@@@@@@"
    lateinit var config: RealmConfiguration
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.i(TAG, "OnCreate fired!")
        setContentView(R.layout.activity_main)

        // Initialization of Realm local database
        Realm.init(this)

        config = RealmConfiguration.Builder().name("AndroidShop")
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        realm.deleteAll()
        realm.commitTransaction()


        // Get Products data from server
        ProductApi.create().getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe({ list ->
                realm.executeTransaction { r ->
                    r.copyToRealmOrUpdate(list)
                }
//                Log.i("@@@@", list.map { p -> p.toString() }.toString())
            }, { e ->
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            })

        // Get Category data from server
        CategoryApi.create().getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe({ list ->
                realm.executeTransaction { r ->
                    r.copyToRealmOrUpdate(list)
                }
            }, { e ->
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            })



        // Replace FrameLayout container with MainFragment
        val fragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onStart() {
        super.onStart()
//        Log.i(TAG, "onStart fired!")
    }

    override fun onResume() {
        super.onResume()
//        Log.i(TAG, "onResume fired!")
    }

    override fun onPause() {
        super.onPause()
//        Log.i(TAG, "onPause fired!")
    }

    override fun onStop() {
        super.onStop()
//        Log.i(TAG, "onStop fired!")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.i(TAG, "onDestroy fired!")
    }
}