package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Order
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.OrderHistory
import kotlinx.android.synthetic.main.activity_orders_history.*
import kotlinx.android.synthetic.main.activity_products.*
import okhttp3.*
import java.io.IOException

class OrdersHistoryActivity : AppCompatActivity() {

    private lateinit var client: OkHttpClient
    private lateinit var order: Array<OrderHistory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_history)

        client = OkHttpClient()

         val bundle :Bundle?=intent.extras
         var idP =bundle!!.getString("id")

        val url = "https://fakestoreapi.com/carts/user/$idP"
        recyclerOrders.layoutManager = LinearLayoutManager(this)
        val clientRecycler = OkHttpClient()

        val request = Request.Builder().url(url).build()

        clientRecycler.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.e(ORDERS_ACTIVITY_LOG_KEY, "PostsRequest Failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    val gson = Gson()
                    println(body)
                    val orders = gson.fromJson(body, Array<OrderHistory>::class.java)
                    orders.forEach { Log.i(ORDERS_ACTIVITY_LOG_KEY, it.toString()) }

                    // ui updates
                    Handler(Looper.getMainLooper()).post {
                        val orderAdapter = OrdersHistoryAdapter(orders, this@OrdersHistoryActivity)
                        recyclerOrders.adapter = orderAdapter


                        orderAdapter.setOnItemClickListener(object :
                            OrdersHistoryAdapter.onItemClickListener {
                            override fun onItemClick(position: Int, ) {

                                val id = orders[position].orderH[position].id.toString()
                                Toast.makeText(
                                    this@OrdersHistoryActivity,
                                    "You click ID: $id",
                                    Toast.LENGTH_LONG
                                ).show()

                                // doesnt work, to send to the product selected page
                                /*
                                val intent = Intent(this, ItemActivity::class.java)
                                intent.putExtra("id", order[position].id)
                                startActivity(intent)
                                */


                            }

                        })


                    }
                }

            }
        })


    }
    }
