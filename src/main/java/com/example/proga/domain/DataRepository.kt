package com.example.proga.domain

import com.example.proga.data.room.User
import com.example.proga.domain.SampleData

interface DataRepository {

    fun saveData(sampleData: SampleData): Boolean

    fun getData(): SampleData
}

interface UserRepository {

    fun saveUserData(user : User): Boolean

    fun getUserData() : User
}