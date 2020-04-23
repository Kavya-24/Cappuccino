package com.example.ashoka.ui.auth

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ashoka.R
import com.example.ashoka.api_interface.RetrofitClient
import com.example.ashoka.objects.pwd
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class pwd_signup : Fragment() {

    lateinit var pwd: TextInputEditText
    lateinit var cnf: TextInputEditText
    var isSuccessful: Boolean = false

    companion object {
        fun newInstance() = pwd_signup()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.pwd_signup_fragment, container, false)

        pwd = root.findViewById(R.id.user_signup_pwd)
        cnf = root.findViewById(R.id.confirm_pwd)

        root.findViewById<CardView>(R.id.cv_next_sign_pwd).setOnClickListener {
            validatePwd()
            if (isNetworkConnected()) {
                if (isSuccessful) {

                    postPassword(pwd)
                    root.findNavController().navigate(R.id.action_pwd_signup_to_nav_home)
                }


            } else {
                AlertDialog.Builder(context).setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again")
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()

            }


        }




        return root
    }

    private fun postPassword(pwd: TextInputEditText?) {
        val service = RetrofitClient.makeRetrofitAuthCall()
        val password = com.example.ashoka.objects.pwd(pwd?.text.toString())
        val call = service.postPassword(password)
        call.enqueue(object : Callback<pwd> {
            override fun onFailure(call: Call<pwd>, t: Throwable) {

                Toast.makeText(context, t.message.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<pwd>, response: Response<pwd>) {
                //Check if this data is sent successfully
                Toast.makeText(
                    context,
                    "Account craeted successfully with code: " + response.body(),
                    Toast.LENGTH_SHORT
                ).show()

            }
        })


    }

    private fun validatePwd() {
        if (pwd.length() == 0) {
            pwd.error = "Password can not be empty"
        }
        if (cnf.length() == 0) {
            cnf.error = "Confirmed Password can not be empty"
        }

        if (pwd.length() < 6 && pwd.length() != 0) {
            pwd.error = "Password should be greater than 6 characters"
        } else if (pwd.text != cnf.text) {
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
        } else {
            isSuccessful = true
        }

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
