package com.example.ashoka.ui.pools

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class my_pool_details : Fragment() {


    private lateinit var my_pool_detailViewModel: MyPoolDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    my_pool_detailViewModel = ViewModelProviders.of(this).get(MyPoolDetailsViewModel::class.java)
        val r = inflater.inflate(R.layout.my_pool_details_fragment, container, false)
        return r




    }




}
