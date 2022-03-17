package com.example.proga.data

import android.content.Context
import com.example.proga.data.firebase.FirebaseManager
import com.example.proga.data.firebase.UserFirebase
import com.example.proga.data.room.AppDb
import com.example.proga.data.room.User
import com.example.proga.domain.SampleData
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class RoomStorage(context: Context) : UserStorage {
    private val firebaseManager = FirebaseManager()

    private val userDao = AppDb.getDatabase(context).userDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun saveUser(user: User): Boolean {
        coroutineScope.launch {
            userDao.insert(user)
        }
        val userFirebase = UserFirebase(
            name = user.name,
            name2 = user.name2,
            name3 = user.name3,
            name4 = user.name4,
            name5 = user.name5,
            name6 = user.name6,
            key = firebaseManager.db.push().key,
            uid = firebaseManager.auth.uid,
        )

        firebaseManager.addUser(userFirebase, null)
        return true
    }

    override fun getUser(): User {
        val users = runBlocking {
            withContext(Dispatchers.Default) { userDao.getName() }
        }
        val userLast = if (users.isNullOrEmpty()) {
            User(name = "no data")
        } else {
            users.last()
        }
        return userLast
    }
}