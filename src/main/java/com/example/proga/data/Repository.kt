package com.example.proga.data

import com.example.proga.domain.DataRepository
import com.example.proga.domain.SampleData

class Repository(private val dataStorage: DataStorage) : DataRepository {
    override fun saveData(sampleData: SampleData): Boolean {
        return dataStorage.save(sampleData = sampleData)
    }

    override fun getData(): SampleData {
        return dataStorage.get()
    }
}