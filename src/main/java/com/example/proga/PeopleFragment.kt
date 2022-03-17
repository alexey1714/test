package com.example.proga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proga.data.firebase.FirebaseManager
import com.example.proga.data.firebase.UserFirebase
import com.example.proga.databinding.FragmentPeopleBinding
import com.example.proga.databinding.FragmentSettingBinding


class PeopleFragment : Fragment(), FirebaseManager.ReadDataCallback {

    lateinit var binding: FragmentPeopleBinding

    companion object {
        fun newInstance() = PeopleFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firebaseManager = FirebaseManager()
        firebaseManager.getAllUsers(this)


    }

    override fun readData(list: ArrayList<UserFirebase>) {


        list.forEach {
            println("polzovatel" + it.uid)
        }
        val adapter = CustomRecyclerAdapter(list)
        binding.recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerView2.adapter = adapter
    }

}