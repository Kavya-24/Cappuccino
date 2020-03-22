package com.example.ashoka.ui.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentFoodAmountViewModel : ViewModel() {
    private val _areaValue = MutableLiveData<String>().apply {
        value = "0.00"
    }
    val areaValue: LiveData<String> = _areaValue



}


