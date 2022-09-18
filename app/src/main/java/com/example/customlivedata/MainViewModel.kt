package com.example.customlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val event = MutableLiveData<Boolean>(false)

    fun trigger(){
        viewModelScope.launch {
            delay(3000)
            event.postValue(true)
        }
    }
}