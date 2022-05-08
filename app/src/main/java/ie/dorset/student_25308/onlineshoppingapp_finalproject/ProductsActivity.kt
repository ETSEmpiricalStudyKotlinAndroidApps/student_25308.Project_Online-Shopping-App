package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Products
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.recycler_products.*
import okhttp3.*
import java.io.IOException


class ProductsActivity :AppCompatActivity(){

    //lateinit var urlProducts: String
   // private lateinit var newArray: ArrayList<Products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // variables
        val userId = intent.getStringExtra("uid")
        val bundle :Bundle?=intent.extras
        var cat =bundle!!.getString("heading")
        val urlProducts = "https://fakestoreapi.com/products/category/$cat"

        recyclerView_products.layoutManager = LinearLayoutManager(this)



        val clientRecycler = OkHttpClient()
        val requestR= Request.Builder().url(urlProducts).build()

        clientRecycler.newCall(requestR).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {

                Log.e(PRODUCTS_ACT_KEY, "Exception: $e")
            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val myResponse = response.body?.string()
                    println(myResponse)
                    val gson= Gson()
                    val info = gson.fromJson(myResponse, Array<Products>::class.java)
                    info.forEach { Log.i(PRODUCTS_ACT_KEY, it.toString()) }




                    Handler(Looper.getMainLooper()).post {

                        val mainAdapter = ProductsAdapter(info , this@ProductsActivity)
                        recyclerView_products.adapter = mainAdapter
                        mainAdapter.setOnItemClickListener(object : ProductsAdapter.onItemClickListener{



                            override fun onItemClick(position: Int,) {
                                val id = info[position].id.toString()
                               // Toast.makeText(this@ProductsActivity, "You click ID: $id",Toast.LENGTH_LONG).show()

                                val intent =Intent(this@ProductsActivity,ItemActivity::class.java)
                               intent.putExtra("id", id)
                                val uID = userId
                                intent.putExtra("uid", uID)
                               startActivity(intent)



                            }


                        })
                    }

                }



                }


        })

    }
}