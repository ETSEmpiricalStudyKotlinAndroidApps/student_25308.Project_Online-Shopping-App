package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Category
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.ProductsOrder
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.User
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.UserP
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)


        val userId = intent.getStringExtra("uid")
        // categories button
        val categoriesButton =findViewById<Button>(R.id.button_categoriesToDiscover)
        categoriesButton.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            val uID = userId
            intent.putExtra("uid", uID)
            startActivity(intent)

        }
        // User button
        val userButton = findViewById<Button>(R.id.button_YourProfile2)
       userButton.setOnClickListener {
       val intent = Intent(this, UserProfile::class.java)

           val uID = userId
           intent.putExtra("uid", uID)

       startActivity(intent)

        }


        // Orders button
        val allOrders = findViewById<Button>(R.id.button_OrdersHistory)
        allOrders.setOnClickListener {
            val intent = Intent(this, OrdersHistoryActivity::class.java)
            val uID = userId
            intent.putExtra("uid", uID)
            startActivity(intent)
        }



    }

}