package com.example.ashoka.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.ashoka.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        root.findViewById<View>(R.id.add_btn_main_page).setOnClickListener{view : View->
            view.findNavController().navigate(R.id.action_nav_home_to_nav_digitalize_land)

        }
        root.findViewById<View>(R.id.what_to_grow_cv).setOnClickListener{view :View->
            view.findNavController().navigate(R.id.action_nav_home_to_what_to_grow2)
        }


        //Get Help.
        root.findViewById<View>(R.id.call_btn).setOnClickListener { view:View->
            val number : String = "+91 9610306949"

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(number)))
            startActivity(intent)
        }




        return root
    }
}