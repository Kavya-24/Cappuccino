package com.example.ashoka.ui.auth

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class aadhaar_email : Fragment() {

    companion object {
        fun newInstance() = aadhaar_email()
    }

    private lateinit var viewModel: AadhaarEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.aadhaar_email_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AadhaarEmailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
