package com.example.ashoka.Utils

import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Parcel
import android.provider.Settings
import androidx.appcompat.app.AlertDialog


abstract class GPS_Tracker(private val mContext: Context) : Service(),
    LocationListener {

    // flag for GPS status
    var isGPSEnabled = false

    // flag for network status
    var isNetworkEnabled = false

    // flag for GPS status
    var canGetLocation = false
    var latitude = 0.0
    var longitude = 0.0

    // Declaring a Location Manager
    var locationManager: LocationManager? = null
    var location: Location? = null


    //Stop Using GPS
    fun stopUsingGPS() {
        locationManager?.removeUpdates(this@GPS_Tracker)
    }

    fun lat(): Double {
        if (location != null) {
            latitude = location!!.latitude
        }
        return latitude
    }

    fun long(): Double {
        if (location != null) {
            longitude = location!!.longitude
        }
        return longitude
    }

    fun canGetLocation(): Boolean {
        return this.canGetLocation
    }

    //Check permission for getting the location Dialog Box
    fun showSettingsAlert() {
        AlertDialog.Builder(mContext).setTitle("Activate GPS")
            .setMessage("Location services are not turned on yet. Do you wish to turn them on?")
            .setPositiveButton("Ok") { dialogInterface, which ->
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                mContext.startActivity(intent)
            }.setNegativeButton(android.R.string.cancel) { _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }


}

