package com.example.ashoka.ui.myLands

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashoka.R
import com.example.ashoka.adapters.land_list_adapter
import com.example.ashoka.models.farmer_land

class myLands : Fragment() {


//    private lateinit var myLandsViewModel: MyLandsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        myLandsViewModel =
//            ViewModelProviders.of(this).get(MyLandsViewModel::class.java)
        val root = inflater.inflate(R.layout.my_lands_fragment, container, false)

        //Create a view model to access the objects on this screen.
        //Get rv
        val rv = root.findViewById<RecyclerView>(R.id.rv_my_lands)
//        rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//
//        val landL = ArrayList<Land_farmer>()
//        landL.add(Land_farmer(1, "Kavya", "234", "djajkn"))
//        landL.add(Land_farmer(2, "Kavya", "234", "djajkn"))
//
//        //Initialize adapter:
//        val a = land_list_adapter(landL)
//        rv.adapter = a

//        var adapter = UsersAdapter(generateData())
//        val layoutManager = LinearLayoutManager(applicationContext)
//        recyclerView?.layoutManager = layoutManager
//        recyclerView?.itemAnimator = DefaultItemAnimator()
//
//        recyclerView?.adapter = adapter
//        adapter.notifyDataSetChanged()
//        ....
//        fun generateData(): ArrayList<UserDto> {
//            var result = ArrayList<UserDto>()
//
//            for (i in 0..9) {
//                var user: UserDto = UserDto("Bett", "Awesome work ;)")
//                result.add(user)
//            }
//
//            return result
//        }
//
        var adapter = land_list_adapter(generateData())
        val layoutManager = LinearLayoutManager(context)
        rv.layoutManager = layoutManager
        rv.itemAnimator = DefaultItemAnimator()
        rv.adapter = adapter
        adapter.notifyDataSetChanged()

        return root

    }

    private fun generateData(): ArrayList<farmer_land> {
        val res = ArrayList<farmer_land>()
        res.add(farmer_land("Kavya", "a lot", "Happy ME"))

        res.add(farmer_land("Kavya", "a lot", "ok mE"))

        res.add(farmer_land("VS", "a lot", "Happy ME"))

        return res
    }


}
