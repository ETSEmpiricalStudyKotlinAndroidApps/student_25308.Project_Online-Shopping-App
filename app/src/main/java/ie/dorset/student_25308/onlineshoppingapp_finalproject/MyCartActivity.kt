package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.OrderHistory
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.User
import okhttp3.OkHttpClient

class MyCartActivity : AppCompatActivity() {
// all Orders
    //OrderHistory
    //OrderH
    //Productos

    private lateinit var client: OkHttpClient
    private lateinit var users: Array<OrderHistory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mycart)

        client = OkHttpClient()
        makeRequest()
}
    private fun makeRequest(){

        val url = "https://fakestoreapi.com/carts/user/2"





    }


}