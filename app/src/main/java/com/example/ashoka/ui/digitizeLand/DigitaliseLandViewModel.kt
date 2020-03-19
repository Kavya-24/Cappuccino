package com.example.ashoka.ui.digitizeLand

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DigitaliseLandViewModel : ViewModel() {
    // TODO: Implement the ViewModel
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is Digitalize land Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _textDesc = MutableLiveData<String>().apply {
        value= "Fill in the details below"
    }
    val textDesc: LiveData<String> =_textDesc


//    private val _textGetLocation = MutableLiveData<String>().apply {
//        value= "Click to get location"
//
//    }
//    val textGetLocation: LiveData<String> =_textGetLocation


    private val _textArea = MutableLiveData<String>().apply {
//        value= "Click to get location"

    }
    val textArea: LiveData<String> =_textArea

    private val _textLocation = MutableLiveData<String>().apply {
  //      value= "Click to get location"

    }
    val textLocation: LiveData<String> =_textLocation



}
