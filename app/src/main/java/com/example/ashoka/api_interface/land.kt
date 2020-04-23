package com.example.ashoka.api_interface

import com.example.ashoka.objects.add_land
import retrofit2.http.Body
import retrofit2.http.POST

interface land {
  //Interface for all the API calls for the land
  //Add land from digitize land:
  //To send : Latitude, longitude, location(numberDecimal) -> ALl float, crops string
  @POST("test1")
  fun addLandRequest(@Body addLand: add_land): retrofit2.Call<add_land>


//    //Get the details of his land
//    @GET
//
//    //View pending land requests
//    @GET
//
//    //View rejected land requests
//    @GET
//
//    //Get the total land of the farmer associated
//    @GET
//
//    //Get the land of the farmer associated in a particular pool
//    @GET
//
//    //Get Land Location
//    @GET
//


}