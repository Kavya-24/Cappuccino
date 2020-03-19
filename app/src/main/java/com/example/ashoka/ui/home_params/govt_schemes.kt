package com.example.ashoka.ui.home_params

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class govt_schemes : Fragment() {

    companion object {
        fun newInstance() = govt_schemes()
    }

    private lateinit var viewModel: GovtSchemesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.govt_schemes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GovtSchemesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
