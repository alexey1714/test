package com.example.proga.data.firebase

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseManager {
    val db = Firebase.database.getReference(LIST_USER)
    val auth = Firebase.auth

    fun addUser(userFirebase: UserFirebase, finishListener: FinishWorkListener?) {

        if (auth.uid != null) db.child(userFirebase.key ?: "empty").child(auth.uid!!)
            .child(USER_NODE).setValue(userFirebase).addOnCompleteListener {
            finishListener?.onFinish()
        }
    }

    fun getAllUsers(readDataCallback: ReadDataCallback?){
        val query = db.orderByChild(auth.uid + "/users")
        readDataFromDb(query, readDataCallback)
    }

    private fun readDataFromDb(query: Query, readDataCallback: ReadDataCallback?) {
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val listUsers = ArrayList<UserFirebase>()
                for (item in snapshot.children) {
                    var user: UserFirebase? = null
                    item.children.forEach {
                        if (user == null) user =
                            it.child(USER_NODE).getValue(UserFirebase::class.java)
                    }
                    user?.let { listUsers.add(it) }
                }
                readDataCallback?.readData(listUsers)
            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }

    interface ReadDataCallback {
        fun readData(list: ArrayList<UserFirebase>)
    }

    interface FinishWorkListener {
        fun onFinish()
    }

    companion object {
        const val USER_NODE = "user"
        const val LIST_USER = "users"
    }



}
