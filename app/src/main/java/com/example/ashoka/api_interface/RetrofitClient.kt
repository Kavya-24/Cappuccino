package com.example.ashoka.api_interface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://www.json-generator.com/api/json/get/"

    fun makeRetrofitHomeCall(): home_page {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(home_page::class.java)
    }


    fun makeRetrofitAuthCall() : auth{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(auth::class.java)



    }

//    val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

   // val response_wtg  = retrofit.create((home_page::class.java)).getWtg()
//


}
