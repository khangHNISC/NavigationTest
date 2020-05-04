package com.example.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedVM : ViewModel() {

    private val _fakeData = MutableLiveData<String>()

    val fakeData: LiveData<String>
        get() = _fakeData

    fun setData(data: String) {
        _fakeData.postValue(data)
    }
}