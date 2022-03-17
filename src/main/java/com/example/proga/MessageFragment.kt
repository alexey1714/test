package com.example.proga

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proga.activities.ChatActivity
import com.example.proga.databinding.FragmentMessageBinding
import com.example.proga.databinding.FragmentSettingBinding
import kotlin.concurrent.fixedRateTimer

class MessageFragment : Fragment(){
    lateinit var binding: FragmentMessageBinding
    companion object {
        fun newInstance() = MessageFragment()
    }
    lateinit var listener : INavMainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavMainActivity){
            listener = context
        }
    }

    fun clic() {
        binding.btnMes.setOnClickListener {
            listener.goToChat()
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clic()

        }
    }

