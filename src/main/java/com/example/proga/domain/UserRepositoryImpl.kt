package com.example.proga.domain

import com.example.proga.data.UserStorage
import com.example.proga.data.room.User

class UserRepositoryImpl(private val userStorage : UserStorage) : UserRepository{
    override fun saveUserData(user: User): Boolean {
        userStorage.saveUser(user)
        return true
    }

    override fun getUserData(): User {
       return userStorage.getUser()
    }
}