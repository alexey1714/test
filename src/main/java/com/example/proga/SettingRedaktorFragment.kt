package com.example.proga

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.proga.data.room.User
import com.example.proga.databinding.FragmentSettingRedaktorBinding
import com.example.proga.domain.DataRepository
import com.example.proga.domain.MainViewModelUser


class SettingRedaktorFragment : Fragment() {

    private lateinit var binding: FragmentSettingRedaktorBinding
    private lateinit var vm: MainViewModelUser
    private lateinit var listener: INavMainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is INavMainActivity) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSettingRedaktorBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory(requireContext())
        )[MainViewModelUser::class.java]
        vm.resultLiveData.observe(this, { user ->
            binding.name.setText(user.name)
            binding.familia.setText(user.name2)
            binding.inters.setText(user.name3)
            binding.price.setText(user.name4)
            binding.sharaga.setText(user.name5)
            binding.rayon.setText(user.name6)
        })
        binding.saveSet.setOnClickListener {
            if (binding.name.text.isNotEmpty()) {
                val user = User(name = binding.name.text.toString(), name2 = binding.familia.text.toString(), name3 = binding.inters.text.toString(),
                    name4 = binding.price.text.toString(), name5 = binding.sharaga.text.toString(), name6 = binding.rayon.text.toString())
                vm.save(user).also {
                    listener.goToSettingFrag()
                }

            }
        }


    }
}