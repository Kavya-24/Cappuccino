package com.example.ashoka.ui.Join_Create_Pool

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

import com.example.ashoka.R
import com.example.ashoka.ui.gallery.GalleryViewModel

class join_create_pool : Fragment() {


    private lateinit var joinCreatePoolViewModel: JoinCreatePoolViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        joinCreatePoolViewModel =
            ViewModelProviders.of(this).get(JoinCreatePoolViewModel::class.java)
        val root = inflater.inflate(R.layout.join_create_pool_fragment, container, false)

       root.findViewById<Button>(R.id.button_create_pool).setOnClickListener{view :View->
           view.findNavController().navigate(R.id.action_nav_join_create_pool_land_to_create_pool)
       }



        root.findViewById<Button>(R.id.button_join_pool).setOnClickListener{view :View->
            view.findNavController().navigate(R.id.action_nav_join_create_pool_land_to_pool_nearby)
        }





        return root
    }

}
