package com.example.ashoka.api_interface

import com.example.ashoka.objects.aadhar
import com.example.ashoka.objects.pwd
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface auth {
    //Login Signup API

    //fun signIn():

    //To send data to the server, we have three parts
    //Request Line : Method, URL,  HTTP version
    //MetaData
    //Send data to the server inn form of
    //1) Json or 2) Form URL encoded

    //Post Aadhar
    @POST("posts")
    fun postAadhar(@Body newAadhar : aadhar) : Call<aadhar>

    //Post password (For signUp password)
    @POST("posts")
    fun postPassword(@Body password : pwd) : Call<pwd>





    //Signup Call
//    @POST
//
//    //Login Call
//    @POST

}