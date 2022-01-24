package com.androiddevs.mvvmnewsapp.API

import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    //companion object.Đối tượng này sẽ được chia sẻ giữa tất cả các trường hợp của lớp, giống như một trường tĩnh trong Java.
    //Do đó, chúng có thể được sử dụng để thực hiện factory phương thức patterns
    companion object{

        /* có thể log lại nhật ký để thuận tiện debugging */
        private  val retrofit by lazy{
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}