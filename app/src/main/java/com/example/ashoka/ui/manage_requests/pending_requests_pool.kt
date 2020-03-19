package com.example.ashoka.ui.manage_requests

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R
import com.example.ashoka.ui.gallery.GalleryViewModel

class pending_requests_pool : Fragment() {


    private lateinit var pend_poolViewModel: PendingRequestsPoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        pend_poolViewModel =
            ViewModelProviders.of(this).get(PendingRequestsPoolViewModel::class.java)
        val root = inflater.inflate(R.layout.pending_requests_pool_fragment, container, false)

    return root


    }


}
