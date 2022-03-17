package com.example.proga

import android.app.Application
import androidx.room.Room
import com.example.proga.data.room.AppDb

class App : Application() {

    var roomDb : AppDb? = null

    companion object{
        fun getDb() = App().createDb()
    }

    override fun onCreate() {
        super.onCreate()

    }

    private fun createDb() : AppDb{
        return Room.databaseBuilder(
            applicationContext,
            AppDb::class.java, "dbr"
        ).build()
    }

}