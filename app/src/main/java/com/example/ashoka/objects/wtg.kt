package com.example.ashoka.objects

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//Data class object

data class wtg(val id : Long,
               val title : String,
               val desc : String,
               val url :String  ) {


     //Change the variable names
     //Title = head
     //body = desc
     //url= img_url



 }