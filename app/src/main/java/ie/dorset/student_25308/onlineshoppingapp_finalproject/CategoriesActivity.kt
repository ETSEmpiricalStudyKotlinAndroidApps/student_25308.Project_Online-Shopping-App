package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Category
import kotlinx.android.synthetic.main.activity_categories.*
import okhttp3.*
import java.io.IOException


class CategoriesActivity :AppCompatActivity(R.layout.activity_categories) {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList1: ArrayList<Category>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        heading = arrayOf("electronics", "jewelery", "men's clothing", "women's clothing")
        val userId = intent.getStringExtra("uid")
        newRecyclerView = findViewById(R.id.recyclerView_categories)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList1 = arrayListOf<Category>()
        makeRequest()
        getData()

        var adapter = CategoriesAdapter(newArrayList1)
        recyclerView_categories.adapter = adapter
        adapter.setOnItemClickListener(object : CategoriesAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

               //Toast.makeText(this@CategoriesActivity, "You click $position", Toast.LENGTH_LONG) .show()

                val intent = Intent(this@CategoriesActivity, ProductsActivity::class.java)
                intent.putExtra("heading", newArrayList1[position].heading)
                val uID = userId
                intent.putExtra("uid", uID)
               startActivity(intent)
            }


        })

    }


    fun getData() {

        for (i in heading.indices) {
            val cat = Category(heading[i])
            newArrayList1.add(cat)
        }
        newRecyclerView.adapter = CategoriesAdapter(newArrayList1)

    }


    fun makeRequest() {

        val url = "https://fakestoreapi.com/products/categories"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(CATEGORIES_ACT_KEY, "Exception: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    println("Hola.....$body")
                    val gson=Gson()
                   // heading= gson.fromJson (body,heading )
                }

            }
        })
    }
}


        /*
        val url = "https://fakestoreapi.com/products/categories"
        val request=Request.Builder().url(url).build()
        val client =OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(CATEGORIES_ACT_KEY, "Exception: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body =response.body?.string()
                    println(body)
                    val gson =Gson()
                  val homeFeed=  gson.fromJson(body, Array<Category>::class.java)


                   // val categoriesT = gson.fromJson(body ,L)
                   // val categoryTitle = listOf<String>(homeFeed)
                    //println(homeFeed)
                   //val categoryTitle = listOf<String>("electronics","jewelery","men's clothing","women's clothing")

                    runOnUiThread{
                       // val mainAdapter = CategoriesAdapter(homeFeed)
                        //recyclerView_categories.adapter=mainAdapter
                    }

                }
                }



         })
    }*/




