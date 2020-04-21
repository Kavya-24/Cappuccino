package com.example.ashoka.ui.home_params

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashoka.R
import com.example.ashoka.adapters.wtg_adapter
import com.example.ashoka.api_interface.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class what_to_grow : Fragment() {

    lateinit var message: String

    companion object {
        fun newInstance() = what_to_grow()
    }


    lateinit var rv: RecyclerView
    lateinit var a: wtg_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.what_to_grow_fragment, container, false)
        rv = root.findViewById(R.id.rv_what_to_grow)
        a = wtg_adapter(requireContext())
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = a



        if (isNetworkConnected()) {
            val service = RetrofitClient.makeRetrofitHomeCall()
            CoroutineScope(Dispatchers.IO).launch {
                val response = service.getWtg()
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                            a.setItems(response.body()!!)


                        } else {

                            Toast.makeText(context, "Error: ${response.code()}", Toast.LENGTH_SHORT)
                                .show()

                        }

                    } catch (e: HttpException) {
                        Toast.makeText(context, "Exception ${e.message}", Toast.LENGTH_SHORT).show()
                    } catch (e: Throwable) {
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        } else {
            AlertDialog.Builder(context).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }




        return root
    }

    private fun isNetworkConnected(): Boolean {


        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    }
}