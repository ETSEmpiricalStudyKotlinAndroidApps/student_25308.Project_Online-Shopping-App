package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.ItemProduct
import okhttp3.*
import java.io.IOException

class ItemActivity:AppCompatActivity() {

    var quantitySelected: Int = 0
    var qSend :String= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val idProduct: TextView = findViewById(R.id.productId_order)
        val idSelected = intent.getStringExtra("id")
        idProduct.text = idSelected


       // var currentPrice : Int = 0
      //  var currentName :String ="hello"

        // variables
        val itemName = findViewById<TextView>(R.id.name_textView)
        val itemDescription = findViewById<TextView>(R.id.description_textView)
        val itemPrice = findViewById<TextView>(R.id.price_textView)
        val itemCategory = findViewById<TextView>(R.id.category_product_textView)
        val imageProduct = findViewById<ImageView>(R.id.productOrder_imageView)
        val rateProduct = findViewById<TextView>(R.id.rate_TextView)
        val countProduct = findViewById<TextView>(R.id.count_TextView)



        val urlItem = "https://fakestoreapi.com/products/$idSelected"
        val clientItem = OkHttpClient()
        val requestItem = Request.Builder().url(urlItem).build()

        clientItem.newCall(requestItem).enqueue(object : Callback {
            var mainHandler = Handler(this@ItemActivity.getMainLooper())
            override fun onFailure(call: Call, e: IOException) {
                // imageView_avatar.setImageResource(R.drawable.ic_baseline_error_outline_24)
                Log.e(ITEM_ACT_KEY, "Exception: $e")
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    mainHandler.post {
                        val responseItem = response.body?.string()
                        println(responseItem)
                        val gson = GsonBuilder().create()
                        val itemInfo = gson.fromJson(responseItem, ItemProduct::class.java)

                        var currentPrice = itemInfo.price
                        var currentName =itemInfo.title

                        itemName.text = itemInfo.title
                        itemDescription.text = itemInfo.description
                        itemPrice.text = itemInfo.price.toString()
                        itemCategory.text = itemInfo.category
                        val imageUrl = itemInfo.image

                        Picasso.get().load(imageUrl)
                            .placeholder(getDrawable(R.drawable.ic_baseline_error_outline_24)!!)
                            .error(
                                getDrawable(R.drawable.ic_baseline_error_outline_24)!!
                            ).memoryPolicy(
                            MemoryPolicy.NO_CACHE
                        ).into(imageProduct)
                    }

                }
            }


        })

        changeQuantity()
        if (idSelected != null) {
            buy(itemPrice.text.toString(), itemName.text.toString() ,idSelected.toInt())
        }


    }

    fun changeQuantity() {
        val minusQ = findViewById<ImageButton>(R.id.minus_imageButton)
        val addQ = findViewById<ImageButton>(R.id.plus_imageButton)
       // val quantitySelected = findViewById<TextView>(R.id.selectProducts_editTextNumber)
        var quantityS = findViewById<TextView>(R.id.selectProducts_editTextNumber)


        minusQ.setOnClickListener {
            if (quantitySelected > 0) {
                quantitySelected -=1
                quantityS.text = quantitySelected.toString()




            }else if(quantitySelected == 0 ){
                Toast.makeText(this@ItemActivity, "You can't select less than 0",Toast.LENGTH_LONG).show()
            }
        }
        addQ.setOnClickListener {
            if(quantitySelected < 15){
                quantitySelected +=1
                quantityS.text = quantitySelected.toString()


            }else if(quantitySelected == 15){
                Toast.makeText(this@ItemActivity, "You can't order more than 15",Toast.LENGTH_LONG).show()
            }
            val userId = intent.getStringExtra("uid")


        }



    }

    fun buy( price : String, itemName :String , productId : Int ){
        val buyButton = findViewById<Button>(R.id.buy_button)


        buyButton.setOnClickListener {
            val quant =findViewById<TextView>(R.id.selectProducts_editTextNumber).text
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("productId",productId)
            intent.putExtra("quantity", quant)
            intent.putExtra("price", price)
            intent.putExtra("nameProduct", itemName)

            println("...............$quant")
            val userId = intent.getStringExtra("uid")
            val uID = userId
            intent.putExtra("uid", uID)
            startActivity(intent)

        }


    }
}