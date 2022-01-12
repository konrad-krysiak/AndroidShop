package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidshop.api.ProductApi
import com.example.androidshop.models.Category
import com.example.androidshop.models.Product
import com.example.androidshop.models.response._Product
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import org.bson.types.ObjectId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        var URL = "http://136f-195-150-224-31.ngrok.io"
    }

    var TAG: String = "@@@@@@@@@@@"
    lateinit var config: RealmConfiguration
    lateinit var backgroundThreadRealm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "OnCreate fired!")
        setContentView(R.layout.activity_main)

        // Initialization of Realm local database
        Realm.init(this)

        val realmName: String = "AndroidShop"
        config = RealmConfiguration.Builder().name(realmName).deleteRealmIfMigrationNeeded().build()
        backgroundThreadRealm = Realm.getInstance(config)

        var init = com.example.androidshop.utils.init()
        var products = init.getProducts()
        Log.i(TAG, products.toString())
//        val products = response.body()
//        Log.i(TAG, products.toString())



//        backgroundThreadRealm.beginTransaction()
//        backgroundThreadRealm.deleteAll()
//        backgroundThreadRealm.commitTransaction()

//        backgroundThreadRealm.beginTransaction()
//        val c1 = backgroundThreadRealm.createObject(Category::class.java, ObjectId())
//        c1.name = "Coffee"
//        val c2 = backgroundThreadRealm.createObject(Category::class.java, ObjectId())
//        c2.name = "Tea"
//        val p1 = backgroundThreadRealm.createObject(Product::class.java, ObjectId())
//        p1._category = c1
//        p1.name = "one"
//        val p2 = backgroundThreadRealm.createObject(Product::class.java, ObjectId())
//        p2._category = c1
//        p2.name = "two"
//        val p3 = backgroundThreadRealm.createObject(Product::class.java, ObjectId())
//        p3._category = c2
//        p3.name = "three"
//        backgroundThreadRealm.commitTransaction()


        // Replace FrameLayout container with MainFragment
        val fragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragmentContainer, fragment)
            .addToBackStack(null)
            .commit()


    }

    override fun onStart() {
        Log.i(TAG, "onStart fired!")
        super.onStart()

//        val c1 = backgroundThreadRealm.where(Category::class.java).findFirst()
//        val coffees = backgroundThreadRealm.where(Product::class.java)
//            .equalTo("_category.name", "Coffee")
//            .findAll()
//            .asJSON()
//
////        val items = backgroundThreadRealm.where(Product::class.java)
////            .findAll().asJSON()
//        Log.i(TAG,coffees)

    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume fired!")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause fired!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop fired!")
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy fired!")
        super.onDestroy()
    }
}