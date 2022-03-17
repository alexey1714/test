package com.example.proga.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "name2") val name2: String? = null,
    @ColumnInfo(name = "name3") val name3: String? = null,
    @ColumnInfo(name = "name4") val name4: String? = null,
    @ColumnInfo(name = "name5") val name5: String? = null,
    @ColumnInfo(name = "name6") val name6: String? = null,
)
