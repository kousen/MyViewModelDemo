package com.oreilly.myviewmodeldemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _greeting = MutableLiveData("Hello, World!")
    val greeting: LiveData<String>
        get() = _greeting

    fun setName(name: String) {
        _greeting.value = "Hello, ${name}!"
    }

}