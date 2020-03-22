package com.example.ashoka.ui.digitizeLand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ashoka.R

class DigitaliseLand : Fragment() {

    private lateinit var digitaliseLand: DigitaliseLandViewModel

    lateinit var tvArea: TextView
    lateinit var tvLocation: TextView
    lateinit var unit_land: String

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

//        val spinner_value = resources.getStringArray(R.array.land_charts_measures)
//        val spinner = root.findViewById<Spinner>(R.id.spinner_area)

//        if (spinner != null) {
//            val adapter = context?.let {
//                ArrayAdapter(
//                    it,
//                    android.R.layout.simple_spinner_item, spinner_value
//                )
//            }
//            spinner.adapter = adapter
//
//            spinner.onItemSelectedListener = object :
//                AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View, position: Int, id: Long
//                ) {
//
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//                    spinner.get(pos)
//                }
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
