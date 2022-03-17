package com.example.proga.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UDao {
    @Query("SELECT * FROM user ")
    fun getName(): List<User>

    @Insert
    fun insert(user : User)
}