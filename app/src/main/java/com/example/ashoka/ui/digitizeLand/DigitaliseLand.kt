package com.example.ashoka.ui.digitizeLand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ashoka.R

class DigitaliseLand : Fragment() {

    private lateinit var digitaliseLand: DigitaliseLandViewModel
    lateinit var option: Spinner
    lateinit var Tv1: TextView
    lateinit var Tv2: TextView
    lateinit var unit_land : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        digitaliseLand =
            ViewModelProviders.of(this).get(DigitaliseLandViewModel::class.java)
        val root = inflater.inflate(R.layout.digitalise_land_fragment, container, false)


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


        // Find the methods
//        option = root.findViewById(R.id.spinner_area) as Spinner
//        Tv1 = root.findViewById(R.id.digitizeArea) as TextView
//        Tv2 = root.findViewById(R.id.digitizeLocation) as TextView
//
//
//        //Set adapter on the option selected
//        val land_chart = arrayOf("Bigha", "Hectare", "Acres", "Yards", "Miles")
//        option.adapter = ArrayAdapter<String>(context,R.array.land_charts_measures,)
//        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                unit_land =
//
//             }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                //This is implemented when the item is changed in the spinner.
//
//
//
//            }
//
//        }

        return root
    }


    private fun getLocation() {
    }

    private fun digitizeLandButton() {


    }


}
