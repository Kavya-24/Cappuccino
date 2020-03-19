package com.example.ashoka.ui.manage_requests

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R
import com.example.ashoka.ui.gallery.GalleryViewModel

class rejected_requests_land : Fragment() {


    private lateinit var rej_landViewModel: RejectedRequestsLandViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rej_landViewModel =
            ViewModelProviders.of(this).get(RejectedRequestsLandViewModel::class.java)
        val root = inflater.inflate(R.layout.rejected_requests_land_fragment, container, false)

        return  root

    }


}
