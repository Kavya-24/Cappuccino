package com.example.ashoka.ui.manage_requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.ashoka.R

class pending_requests_land : Fragment() {


    private lateinit var pend_landViewModel: PendingRequestsLandViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        pend_landViewModel =
            ViewModelProviders.of(this).get(PendingRequestsLandViewModel::class.java)
        val root = inflater.inflate(R.layout.pending_requests_land_fragment, container, false)


        return root

    }


}
