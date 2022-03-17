package com.example.proga.domain

import com.example.proga.data.room.User

class GetUserUseCase(private val userRepository : UserRepository) {
    fun run(): User {
        return userRepository.getUserData()
    }
}