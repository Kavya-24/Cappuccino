package com.example.ashoka.ui.pools

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class my_pools : Fragment() {


    private lateinit var myPoolsViewModel: MyPoolsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       myPoolsViewModel = ViewModelProviders.of(this).get(MyPoolsViewModel::class.java)
        val r = inflater.inflate(R.layout.my_pools_fragment, container, false)


        return  r

       // return inflater.inflate(R.layout.my_pools_fragment, container, false)
    }



}
