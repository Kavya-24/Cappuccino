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
import com.example.ashoka.objects.aadhar
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response

class aadhaar_email : Fragment() {

    companion object {
        fun newInstance() = aadhaar_email()
    }

    lateinit var t1: TextInputEditText
    lateinit var t2: TextInputEditText
    private var isSuccessfull = false
//    private lateinit var viewModel: AadhaarEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.aadhaar_email_fragment, container, false)

        t1 = root.findViewById(R.id.user_aadhaar)
        t2 = root.findViewById(R.id.user_email)


        val b = root.findViewById<CardView>(R.id.cv_next)
        b.setOnClickListener {

            validateAadhar()
            validateEmail()

            if (isNetworkConnected()) {
                if (isSuccessfull) {
                    //Host data online to the server
                    postAadhar_Email(t1, t2)
                    root.findNavController().navigate(R.id.action_aadhaar_email_to_pwd_signup)
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

    private fun postAadhar_Email(t1: TextInputEditText?, t2: TextInputEditText?) {

        val service = RetrofitClient.makeRetrofitAuthCall()
        //Create a parameter to send
        val aadharEmail = aadhar(t1?.text.toString(), t2?.text.toString())

        //The below is returned in a call

        val call = service.postAadhar(aadharEmail)
        //Populated data
        call.enqueue(object : retrofit2.Callback<aadhar> {
            override fun onFailure(call: Call<aadhar>, t: Throwable) {

                Toast.makeText(context, t.message.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<aadhar>, response: Response<aadhar>) {
                //Check if this data is sent successfully
                Toast.makeText(context, "Code is" + response.body(), Toast.LENGTH_SHORT).show()

            }
        })

    }

    private fun validateEmail() {
        if (t2.length() == 0) {
            t2.error = "Email can not be empty"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(t2.text.toString())
                .matches() && t2.length() != 0
        ) {
            //Check if a valid email address
            t2.error = "Invalid email address"
        } else {
            isSuccessfull = true
        }

    }

    private fun validateAadhar() {
        if (t1.length() == 0) {
            t1.error = "Aadhar  number can not be empty"
        } else if (t1.length() < 12 && t1.length() != 0) {
            t1.error = "Invalid Aadhar number"
        } else {
            isSuccessfull = true
        }

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(AadhaarEmailViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    private fun isNetworkConnected(): Boolean {


        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    }

}
