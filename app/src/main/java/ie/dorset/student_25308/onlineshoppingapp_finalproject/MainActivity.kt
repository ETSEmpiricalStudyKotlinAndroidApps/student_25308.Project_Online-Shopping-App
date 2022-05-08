package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.User
import okhttp3.*
import java.io.IOException


const val MAIN_ACT_KEY = "mainAct"

class MainActivity : AppCompatActivity() {


    private lateinit var client: OkHttpClient
    private lateinit var users: Array<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         // add val buttons layout

        val btnLogin =findViewById<Button>(R.id.btnLogin)
        var inputUser = findViewById<TextInputEditText>(R.id.edUsername)
        var inputPass = findViewById<TextInputEditText>(R.id.edPassword)




        client = OkHttpClient()
       // makeRequest()

        btnLogin.setOnClickListener {

            Toast.makeText(this, "Welcome to My Shop $" ,Toast.LENGTH_LONG).show()
            var userName = inputUser.text.toString()
            var passUser = inputPass.text.toString()
                validation(userName, passUser)
                println( "name ::: $userName")
            println (passUser)


           // val intent = Intent(this@MainActivity ,CategoriesActivity::class.java)
            //startActivity(intent)

        }


    }




/*
    fun makeRequest() {
        val url = "https://fakestoreapi.com/users"
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(MAIN_ACT_KEY, "PostsRequest Failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful && response.body != null) {
                    val responseBody = response.body!!.string()
                    val posts = Gson().fromJson(responseBody, Array<User>::class.java)
                    println(posts)



                }
            }
        })



    }
*/

    override fun onStart() {
        super.onStart()
        Log.i(MAIN_ACT_KEY, "onStart called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(MAIN_ACT_KEY, "onPause called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(MAIN_ACT_KEY, "onResume called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(MAIN_ACT_KEY, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MAIN_ACT_KEY, "onDestroy called")
    }

    fun validation ( userName :String , password : String){
        if(userName == "johnd" && password =="m38rmF\$"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "1"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "mor_2314" && password =="83r5^_"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "2"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "kevinryan" && password =="kev02937@"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "3"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "donero" && password =="ewedon"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "4"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "derek" && password =="jklg*_56"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "5"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "david_r" && password =="3478*#54"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "6"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "snyder" && password =="f238&@*\$"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "7"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "hopkins" && password =="William56$"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "8"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "derek" && password =="kfejk@*_"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "9"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else if(userName == "jimmie_k" && password =="klein*#%*"){
            val intent = Intent(this, UserProfile::class.java)
            val uID = "10"
            intent.putExtra("uid", uID)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Enter a valid user " ,Toast.LENGTH_LONG).show()
            //val intent = Intent(this, UserProfile::class.java)
            //startActivity(intent)
        }



    }

}