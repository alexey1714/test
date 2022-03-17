package com.example.proga.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proga.data.room.User


class MainViewModelUser(val getUserUseCase : GetUserUseCase, val saveUserUseCase : SaveUserUseCase) : ViewModel(){

    private val data = MutableLiveData<User>()
    // изолируем объект data от возможности сетить в него данные в активити или фрагменте,
    // так как mutable это реализация конкретная
    val resultLiveData: LiveData<User> = data

    init {
        Log.e("TAG", "ViewModel created")
    }

    fun save(user: User) {

        val result = saveUserUseCase.run(user)

    }

    fun load() {

        data.value = getUserUseCase.run()
    }

    override fun onCleared() {
        Log.e("TAG", "ViewModel cleared")
        super.onCleared()
    }
}