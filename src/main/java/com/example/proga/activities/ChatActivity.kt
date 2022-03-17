package com.example.proga.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.proga.MainActivity
import com.example.proga.MainViewModelFactory
import com.example.proga.databinding.ActivityChatBinding
import com.example.proga.databinding.ActivityMainBinding
import com.example.proga.domain.MainViewModelUser

class ChatActivity : AppCompatActivity() {
    lateinit var bindingC : ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingC = ActivityChatBinding.inflate(layoutInflater)
        setContentView(bindingC.root)

    }


}