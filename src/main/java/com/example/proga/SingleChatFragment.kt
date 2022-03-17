package com.example.proga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proga.databinding.FragmentSettingBinding
import com.example.proga.databinding.FragmentSingleChatBinding


class SingleChatFragment : Fragment(){
    lateinit var binding: FragmentSingleChatBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingleChatBinding.inflate(inflater)
        return binding.root
    }



    override fun onResume() {
        super.onResume()
        //сделать видимым тулбар с инфой
    }

    override fun onPause() {
        super.onPause()
        //сделать невидимым тулбар с инфой
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}