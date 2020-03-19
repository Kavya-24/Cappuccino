package com.example.ashoka.ui.manage_requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ashoka.R

class open_page : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_open_page, container, false)

        val cv1: View = root.findViewById(R.id.cv_plr)
        cv1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_request_page_to_pending_requests_land)
        }
        val cv2: View = root.findViewById(R.id.cv_ppr)
        cv2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_request_page_to_pending_requests_pool)
        }

        val cv3: View = root.findViewById(R.id.cv_rlr)
        cv3.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_nav_request_page_to_rejected_requests_land)
        }

        val cv4: View = root.findViewById(R.id.cv_rpr)
        cv4.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_nav_request_page_to_rejected_requests_pool)
        }



        return root
    }

}
