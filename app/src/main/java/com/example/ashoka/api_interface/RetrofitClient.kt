package com.example.ashoka.api_interface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //Object is used in Kotlin to access the Instantiated Retrofit
    private const val BASE_URL = "https://api.myjson.com/bins"

    //Define a client which is OKHTTP
    //This is needed for Authorisation
//    private  val okHttpClient = OkHttpClient.Builder()
//        .addInterceptor{
//            val ori
//        }
    val instance_land: land by lazy {
        val retrofit1 = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        retrofit1.create(land::class.java)
    }


}
