package com.example.ashoka.ui.home_params

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ashoka.R

class maket_arbitrage : Fragment() {

    companion object {
        fun newInstance() = maket_arbitrage()
    }

    private lateinit var viewModel: MaketArbitrageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.maket_arbitrage_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MaketArbitrageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
