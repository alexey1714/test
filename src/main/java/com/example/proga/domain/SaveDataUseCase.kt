package com.example.proga.domain

import com.example.proga.domain.DataRepository
import com.example.proga.domain.SampleData

class SaveDataUseCase (private val dataRepository: DataRepository) {

    fun run(data: SampleData): Boolean {
        return dataRepository.saveData(data)
    }
}