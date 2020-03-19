package com.example.ashoka.ui.home_params

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class what_to_grow : Fragment() {

    companion object {
        fun newInstance() = what_to_grow()
    }

    private lateinit var viewModel: WhatToGrowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.what_to_grow_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WhatToGrowViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
