package ie.dorset.student_25308.onlineshoppingapp_finalproject

import okhttp3.Interceptor
import okhttp3.Credentials


public class Authentication (username: String, password: String): Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }
}


