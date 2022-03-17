package com.example.proga.domain

import com.example.proga.data.room.User


class SaveUserUseCase(private val userRepository: UserRepository) {
    fun run(user: User): Boolean {
        userRepository.saveUserData(user)
        return true
    }
}