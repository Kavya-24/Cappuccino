package com.example.ashoka.ui.pools

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class pool_nearby : Fragment() {


    private lateinit var joinViewModel: PoolNearbyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        joinViewModel = ViewModelProviders.of(this).get(PoolNearbyViewModel::class.java)
        val r = inflater.inflate(R.layout.pool_nearby_fragment, container, false)
        return r
       // return inflater.inflate(R.layout.pool_nearby_fragment, container, false)
    }


}
