package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.ItemProduct
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Order
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.ProductsOrder
import kotlinx.android.synthetic.main.activity_cart.*
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class CartActivity:AppCompatActivity() {
    private lateinit var client: OkHttpClient
    private lateinit var users: Array<ProductsOrder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        client = OkHttpClient()


        val idOrder = intent.getIntExtra("productId", 9)
        val nameOrder = intent.getStringExtra("nameProduct")
        val priceOrder = intent.getStringExtra("price")
        val quantityOrder = intent.getStringExtra("quantity")

        val idval =findViewById<TextView>(R.id.idItemorder)
        val nameOr =findViewById<TextView>(R.id.item_name_textView)
        val priceOr =findViewById<TextView>(R.id.price_item_textView)
        val quantityOr= findViewById<TextView>(R.id.quantity_order)
        val total1 = findViewById<TextView>(R.id.totalOrder)

        idval.text=idOrder.toString()
        nameOr.text=nameOrder.toString()
        priceOr.text=priceOrder
        quantityOr.text= quantityOrder

        val quantityVar : Double? = quantityOrder?.toDoubleOrNull()

        val priceVar :Double? =priceOrder?.toDoubleOrNull()
        val total = priceVar?.let { quantityVar?.times(it) }
        total1.text =total.toString()

        client = OkHttpClient()

        button_order.setOnClickListener {


            Toast.makeText(this,"Your order has been placed / addPost",Toast.LENGTH_LONG).show()
            if (quantityVar != null) {
                makeAddPostRequest(idOrder,quantityVar.toInt())
                val intent = Intent(this, NotificationActivity::class.java)
                val userId = intent.getStringExtra("uid")
                val uID = userId
                intent.putExtra("uid", uID)
                startActivity(intent)


            }
        }

    }

    private fun makeAddPostRequest(storeid : Int, storeQuantity :Int ){

        val url = "https://fakestoreapi.com/carts"

          val newPost = ProductsOrder().apply{
              productId = storeid
              quantity = storeQuantity
          }

        val request =  Request.Builder().url(url).post(Gson().toJson(newPost).toRequestBody()).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(CART_ACTIVITY_LOG_KEY, "AddPost Failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i(CART_ACTIVITY_LOG_KEY, "AddPost successful, response received, Status code: ${response.code}")


            }
        })
    }


}