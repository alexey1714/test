package com.example.proga.data

import com.example.proga.data.room.User
import com.example.proga.domain.SampleData

interface DataStorage  {

    fun save(sampleData: SampleData): Boolean

    fun get(): SampleData
}

interface UserStorage  {

    fun saveUser(user : User): Boolean

    fun getUser() : User
}

