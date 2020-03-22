package com.example.ashoka.ui.food

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ashoka.R

class fragment_food_amount : Fragment() {

    companion object {
        fun newInstance() = fragment_food_amount()
    }

    private lateinit var viewModel: FragmentFoodAmountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(FragmentFoodAmountViewModel::class.java)
        val root = inflater.inflate(R.layout.list_food_amt, container, false)

        val textView: TextView = root.findViewById(R.id.text_gallery)

        viewModel.areaValue.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        root.findViewById<View>(R.id.ask_advise).setOnClickListener {
            val number : String = "+91 9610306949"

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(number)))
            startActivity(intent)

        }

        root.findViewById<View>(R.id.manual_crop).setOnClickListener {
            getManual()
        }

        root.findViewById<View>(R.id.sell_btn).setOnClickListener {
            sellCrops()
        }




        return root
    }

    private fun sellCrops() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getManual() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
