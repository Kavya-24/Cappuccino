package com.example.ashoka.ui.myLands

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R
import kotlinx.android.synthetic.main.profile_fragment.*

class land_details : Fragment() {


    private lateinit var landDetailsViewModel: LandDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        landDetailsViewModel = ViewModelProviders.of(this).get(LandDetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.land_details_fragment, container, false)

        val crops =




        return root
    }


}
