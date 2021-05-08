package com.melq.mvvm

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(private val pref: SharedPreferences) {

    private val _countNumber: MutableLiveData<Int> =
            MutableLiveData<Int>().also { mutableLiveData ->
                mutableLiveData.value = pref.getInt("count", 0)
            }
    val countNumber: LiveData<Int> get() = _countNumber

    fun countUp(num: Int) {
        _countNumber.value = _countNumber.value?.plus(num)
        pref.edit{ _countNumber.value?.let { putInt("count", it) } }
    }
    fun countReset() {
        _countNumber.value = 0
        pref.edit { putInt("count", 0) }
    }
}