package com.example.ashoka.ui.Join_Create_Pool

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class create_pool : Fragment() {

    companion object {
        fun newInstance() = create_pool()
    }

    private lateinit var create_poolViewModel: CreatePoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        create_poolViewModel = ViewModelProviders.of(this).get(CreatePoolViewModel::class.java)
        val r = inflater.inflate(R.layout.create_pool_fragment, container, false)

        return r



         }


}
