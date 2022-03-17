package com.example.proga

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.proga.activities.SignInActivity
import com.example.proga.databinding.FragmentSettingBinding
import com.example.proga.databinding.FragmentSettingRedaktorBinding
import com.example.proga.domain.MainViewModelUser
import com.google.firebase.auth.FirebaseAuth
import kotlin.concurrent.fixedRateTimer

class SettingFragment : Fragment() {
    lateinit var bindingSet: FragmentSettingBinding
    private val mAuth = FirebaseAuth.getInstance()
    private lateinit var vm: MainViewModelUser

    companion object {
        fun newInstance() = SettingFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        bindingSet = FragmentSettingBinding.inflate(inflater)
        return bindingSet.root


    }

    fun s() {
        val fragmentSR = SettingRedaktorFragment()
        bindingSet.edit.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.frameLayout,
                    fragmentSR,
                    SettingRedaktorFragment::class.java.simpleName
                )
                    .addToBackStack(tag)
                    .commit()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory(requireContext())
        )[MainViewModelUser::class.java]
        bindingSet.exitT.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(activity, SignInActivity::class.java))
        }
        s()
        vm.load()
        vm.resultLiveData.observe(this, { user ->
            bindingSet.exit.text = user.name
        })
    }

}


