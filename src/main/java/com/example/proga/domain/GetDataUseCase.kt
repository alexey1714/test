package com.example.proga.domain

import com.example.proga.domain.DataRepository
import com.example.proga.domain.SampleData

class GetDataUseCase (private val dataRepository: DataRepository) {

    fun run(): SampleData {
        return dataRepository.getData()
    }
}