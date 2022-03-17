package com.example.proga

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proga.domain.GetDataUseCase
import com.example.proga.domain.SampleData
import com.example.proga.domain.SaveDataUseCase

class MainViewModel (val getDataUseCase: GetDataUseCase, val saveDataUseCase: SaveDataUseCase) : ViewModel() {

    private val data = MutableLiveData<String>()
    // изолируем объект data от возможности сетить в него данные в активити или фрагменте,
    // так как mutable это реализация конкретная
    val resultLiveData: LiveData<String> = data

    init {
        Log.e("TAG", "ViewModel created")
    }

    fun save(text: String) {
        val sampleData = SampleData(text = text)
        val result = saveDataUseCase.run(data = sampleData)

    }

    fun load() {
        val sampleData = getDataUseCase.run()
        data.value = sampleData.text
    }

    override fun onCleared() {
        Log.e("TAG", "ViewModel cleared")
        super.onCleared()
    }
}