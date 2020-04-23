package com.example.ashoka.ui.digitizeLand

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.ashoka.R
import com.example.ashoka.api_interface.RetrofitClient
import com.example.ashoka.objects.add_land
import kotlinx.android.synthetic.main.digitalise_land_fragment.*
import retrofit2.Call
import retrofit2.Response

class DigitaliseLand : Fragment() {

    private lateinit var digitaliseLand: DigitaliseLandViewModel
    private val permissionRequestCode = 123

    // private lateinit var managePermissions : ManagePermission
    lateinit var tvArea: TextView
    lateinit var tvLocation: TextView
    lateinit var unit_land: String
    lateinit var t1: TextView
    lateinit var t2: TextView
    lateinit var locationManager: LocationManager
    private var hasGps: Boolean = false
    private var hasNetwork: Boolean = false
    private var locationGPS: Location? = null
    private var locationNetwork: Location? = null
    var lat: Double = 0.0
    var lon: Double = 0.0
    var locality: String = ""
    var crops: String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        digitaliseLand =
            ViewModelProviders.of(this).get(DigitaliseLandViewModel::class.java)
        val root = inflater.inflate(R.layout.digitalise_land_fragment, container, false)


        //Observer for description
        val t: TextView = root.findViewById(R.id.textView8)
        digitaliseLand.textDesc.observe(viewLifecycleOwner, Observer {
            t.text = it
        })

        t1 = root.findViewById(R.id.latTextView)
        t2 = root.findViewById(R.id.lonTextView)
        tvLocation = root.findViewById(R.id.digitizeLocation)
        tvArea = root.findViewById(R.id.digitizeArea)


        val t4: TextView = root.findViewById(R.id.currentLocation)
        t4.setOnClickListener {
            getPermissions()
        }


        val b1: Button = root.findViewById(R.id.button_digitize_land)
        b1.setOnClickListener {
            getCrops(root)
            digitizeLandButton(root)
        }


        return root
    }

    private fun getCrops(view: View) {
        //Card to be selected id

        if (view.findViewById<RadioButton>(R.id.cv1).isChecked) {
            crops += "Potato"
            Toast.makeText(context, "Crop now is $crops", Toast.LENGTH_SHORT).show()
        } else if (view.findViewById<RadioButton>(R.id.cv2).isChecked) {
            crops += "Maize"
        } else if (view.findViewById<RadioButton>(R.id.cv3).isChecked) {
            crops += "Tomato"
        } else if (view.findViewById<RadioButton>(R.id.cv4).isChecked) {
            crops += "Sugarcane"
        } else if (view.findViewById<RadioButton>(R.id.cv5).isChecked) {
            crops += "Onion"
        }


    }

    private fun getPermissions() {
        val p = context?.let {
            ContextCompat.checkSelfPermission(
                it,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        if (p == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Checking if allowed", Toast.LENGTH_SHORT).show()

            getLocation()
        }

        if (p != PackageManager.PERMISSION_GRANTED) {
            //Not permitted
            Toast.makeText(context, "Permissions needed", Toast.LENGTH_SHORT).show()


        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                context as Activity,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            //Tell user what we are going to do with this permission
            val b = AlertDialog.Builder(context)
            b.setMessage("Permission to access location")
            b.setTitle("Permission required")
            b.setPositiveButton("Ok") { dialog: DialogInterface?, which: Int ->
                Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show()
                makeRequest()
            }
            val dialog = b.create()
            dialog.show()
        } else {
            makeRequest()
        }

    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            permissionRequestCode
        )

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            permissionRequestCode ->
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(context, "Permission denied by user", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show()

                }

        }


    }

    private fun digitizeLandButton(view: View) {

        if (tvArea.length() == 0) {
            tvArea.error = "Area can not be empty"
        } else if (latTextView.length() == 0 || lonTextView.length() == 0) {
            Toast.makeText(context, "Click to get location", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(context, "Sending Data...\nCrop sent is:$crops", Toast.LENGTH_SHORT)
                .show()

            postLandData(tvArea.text.toString().toDouble(), lat, lon, crops)
            //Sent data or not
            view.findNavController().navigate(R.id.action_nav_digitalize_land_to_nav_home)
        }


    }

    private fun postLandData(tvArea: Double, lat: Double, lon: Double, crops: String) {

        val service = RetrofitClient.makeRetrofitLandCall()
        //Create object
        val a = add_land(tvArea, lat, lon, crops)
        val call = service.addLandRequest(a)
        //Send
        call.enqueue(object : retrofit2.Callback<add_land> {
            override fun onFailure(call: Call<add_land>, t: Throwable) {

                Toast.makeText(context, t.message.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<add_land>, response: Response<add_land>) {
                //Check if this data is sent successfully
                Toast.makeText(context, "Code is " + response.body(), Toast.LENGTH_SHORT).show()

            }
        })


    }


    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        //If both of them are true
        if (!hasGps) {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
        if (!hasNetwork) {
            startActivity(Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS))
        } else if (hasNetwork) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, object :
                LocationListener {
                override fun onLocationChanged(location: Location?) {
                    //If the location changes
                    if (location != null) {
                        //Update the location by the GPS
                        locationNetwork = location

                    }

                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                }

                override fun onProviderEnabled(provider: String?) {

                }

                override fun onProviderDisabled(provider: String?) {

                }
            })
            //Check for the last location
            val localNetworkLocation =
                locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (localNetworkLocation != null) {
                locationGPS = localNetworkLocation
                t1.text = "Latitude : " + locationGPS!!.latitude.toString()
                t2.text = "Longitude : " + locationGPS!!.longitude.toString()
                t1.visibility = View.VISIBLE
                t2.visibility = View.VISIBLE
                Toast.makeText(context, R.string.get_last_location, Toast.LENGTH_SHORT).show()
            }

        } else if (hasGps) {
            //Successful initial conditions
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, object :
                LocationListener {
                override fun onLocationChanged(location: Location?) {
                    //If the location changes
                    if (location != null) {
                        //Update the location by the GPS
                        locationGPS = location

                    }

                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                }

                override fun onProviderEnabled(provider: String?) {

                }

                override fun onProviderDisabled(provider: String?) {

                }
            })
            //Check for the last location
            val localGpsLocation =
                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (localGpsLocation != null) {
                locationGPS = localGpsLocation
                Toast.makeText(context, R.string.get_last_location, Toast.LENGTH_SHORT).show()
            }
        }

        //Check the accuracy of the location retrieved
        if (locationGPS != null && locationNetwork != null) {
            if (locationGPS!!.accuracy >= locationNetwork!!.accuracy) {
                //PROBLEM IN TYPE OF COORDINATES
                lat = locationNetwork!!.latitude
                lon = locationNetwork!!.longitude
                t1.text = "Latitude: " + locationNetwork!!.latitude.toString()
                t2.text = "Longitude: " + locationNetwork!!.longitude.toString()
                t1.visibility = View.VISIBLE
                t2.visibility = View.VISIBLE

            } else {

                lat = locationGPS!!.latitude
                lon = locationGPS!!.longitude
                t1.text = "Latitude : " + locationGPS!!.latitude.toString()
                t2.text = "Longitude : " + locationGPS!!.longitude.toString()
                t1.visibility = View.VISIBLE
                t2.visibility = View.VISIBLE
            }
        }

//        getLocality(lat, lon)


    }

//    private fun getLocality(t1: Double, t2: Double) {
//        //To get Locality/City
//        val geocoder = Geocoder(context, Locale.ENGLISH)
//        var address: List<Address> = geocoder.getFromLocation(t1, t2, 1)
//        locality = address.get(0).locality
//        tvLocation.text = locality
//    }


}
