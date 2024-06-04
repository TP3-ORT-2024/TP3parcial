package com.uno.tp3parcial.ui.shared_view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _isDarkMode = MutableLiveData<Boolean>()
    val isDarkMode: LiveData<Boolean> = _isDarkMode


    fun setDarkMode(isDarkMode: Boolean) {
        _isDarkMode.value = isDarkMode
    }
}