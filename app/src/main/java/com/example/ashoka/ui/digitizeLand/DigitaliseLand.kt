package com.example.ashoka.ui.digitizeLand

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ashoka.R
import com.google.android.gms.location.FusedLocationProviderClient

class DigitaliseLand : Fragment() {

    private lateinit var digitaliseLand: DigitaliseLandViewModel

    lateinit var tvArea: TextView
    lateinit var tvLocation: TextView
    lateinit var unit_land: String

    // flag for GPS status


    //To get the previously loaded loaction
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        digitaliseLand =
            ViewModelProviders.of(this).get(DigitaliseLandViewModel::class.java)
      val  root = inflater.inflate(R.layout.digitalise_land_fragment, container, false)


        //Observer for description
        val t1: TextView = root.findViewById(R.id.textView8)
        digitaliseLand.textDesc.observe(viewLifecycleOwner, Observer {
            t1.text = it
        })


        val t4: TextView = root.findViewById(R.id.currentLocation)
        t4.setOnClickListener {
            getLocation()
        }


        val b1: Button = root.findViewById(R.id.button_digitize_land)
        b1.setOnClickListener {
            digitizeLandButton()
        }


        return root
    }

    private fun digitizeLandButton() {
    }


    fun getLocation() {

    }


}
