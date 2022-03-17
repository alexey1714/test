package com.example.proga.data

import android.content.Context
import com.example.proga.data.DataStorage
import com.example.proga.domain.SampleData

private const val SHARED_PREF = "shared_pref"
private const val DATA_KEY = "current_data"
private const val DEFAULT_DATA = "Нет данных"

class SharedPrefDataStorage (context: Context) : DataStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    override fun save(sampleData: SampleData): Boolean {
        sharedPreferences.edit().putString(DATA_KEY, sampleData.text).apply()
        return true
    }

    override fun get(): SampleData {
        val text = sharedPreferences.getString(DATA_KEY, DEFAULT_DATA) ?: DEFAULT_DATA
        return SampleData(text = text)
    }
}