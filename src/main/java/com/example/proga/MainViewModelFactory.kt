package com.example.proga

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proga.data.RoomStorage
import com.example.proga.domain.*


class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = RoomStorage(context = context))
    }

    private val getUserUseCase by lazy(LazyThreadSafetyMode.NONE) {
       // GetDataUseCase(dataRepository = dataRepository)
        GetUserUseCase  (userRepository = userRepository)
    }

    private val saveUserUseCase by lazy(LazyThreadSafetyMode.NONE) {
        //SaveDataUseCase(dataRepository = userRepository)
        SaveUserUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModelUser(getUserUseCase = getUserUseCase, saveUserUseCase = saveUserUseCase) as T
    }
}