package com.example.ashoka.api_interface

import com.example.ashoka.objects.wtg
import retrofit2.Response
import retrofit2.http.GET

interface home_page {
    //Api Calls for the Home Page parameters

    //Declare the function and return type
    @GET("bZtssEuzSa?indent=2")
   suspend fun getWtg() :Response<List<wtg>>
//





//
//    //Tempereature
//    @GET
//
//    //Humidity
//    @GET
//
//    //PPT
//    @GET
//
//    //Wind Speed
//    @GET
//
//    //Govt News
//    @GET
//
//    //What to grow
//    @GET
//
//    //Price of each crop
//    @GET
//
//    //Density of each crop production
//    @GET

}