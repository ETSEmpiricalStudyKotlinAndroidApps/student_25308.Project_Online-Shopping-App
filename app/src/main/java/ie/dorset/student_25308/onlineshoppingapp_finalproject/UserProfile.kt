package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import ie.dorset.student_25308.onlineshoppingapp_finalproject.R.drawable.ic_baseline_error_outline_24
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.User
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.UserP
import kotlinx.android.synthetic.main.activity_user.*
import okhttp3.*
import java.io.IOException

class UserProfile : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var client: OkHttpClient
    private val picasso = Picasso.get()
    private lateinit var mMap: GoogleMap


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val mapFragment =supportFragmentManager.findFragmentById(R.id.map)as SupportMapFragment
        mapFragment.getMapAsync(this)

        val userId = intent.getStringExtra("uid")

        var dpUrl="https://thiscatdoesnotexist.com/"
        var avatarImg = findViewById<ImageView>(R.id.imageUser)

        Picasso.get().load(dpUrl).placeholder(getDrawable(ic_baseline_error_outline_24)!!).error(
            getDrawable(ic_baseline_error_outline_24)!!).memoryPolicy(
            MemoryPolicy.NO_CACHE).into(avatarImg)




        client = OkHttpClient()
        makeRequest(userId)


        button_aboutTheApp.setOnClickListener {
            val intent = Intent(this, About::class.java)
            val uID = userId
            intent.putExtra("uid", uID)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val uID = userId
            intent.putExtra("uid", uID)
            startActivity(intent)
        }

        button_shop.setOnClickListener{
            val intent = Intent(this, CategoriesActivity::class.java)
            val uID = userId
            intent.putExtra("uid", uID)
            startActivity(intent)
        }



    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(
            MarkerOptions()
            .position(sydney)
            .title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

    }


    fun makeRequest(userId:String?) {

        var url = "https://fakestoreapi.com/users/$userId"
        val request = Request.Builder().url(url).build()

        val userName = findViewById<TextView>(R.id.userName)
        val firstname = findViewById<TextView>(R.id.nameU)
        val lastname =findViewById<TextView>(R.id.lastName)
        val email =findViewById<TextView>(R.id.email)
        val id=findViewById<TextView>(R.id.idUser)
        val city =findViewById<TextView>(R.id.city)
        val geoLat=findViewById<TextView>(R.id.geoLa)
        val geoLong=findViewById<TextView>(R.id.geoLong)
        val street= findViewById<TextView>(R.id.street)
        val numberadd=findViewById<TextView>(R.id.numberaddr)
        val zipcode=findViewById<TextView>(R.id.zip)
        val phone =findViewById<TextView>(R.id.phone)


        client.newCall(request).enqueue(object : Callback {
            var mainHandler = Handler(this@UserProfile.getMainLooper())
            override fun onFailure(call: Call, e: IOException) {
                Log.e(MAIN_ACT_KEY, "PostsRequest Failed: ${e.message}")
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful && response.body != null) {
                    val responseBody = response.body!!.string()
                    val posts = Gson().fromJson(responseBody, UserP::class.java)
                    println(posts)

                    mainHandler.post{
                        userName.text = posts.username
                       firstname.text = posts.name.firstname
                        lastname.text =posts.name.lastname
                        email.text= posts.email
                       id.text = posts.id.toString()
                       city.text= posts.address.city
                       geoLat.text=  posts.address.geolocation.lat
                        geoLong.text= posts.address.geolocation.long
                        street.text= posts.address.street
                       numberadd.text=   posts.address.number.toString()
                       zipcode.text=  posts.address.zipcode
                       phone.text=  posts.phone
                             posts.address.geolocation.lat

                                          }

                }
            }
        })



    }
}