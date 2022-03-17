package com.example.proga.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proga.MainActivity
import com.example.proga.R
import com.example.proga.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class SignUpActivity : AppCompatActivity() {
    lateinit var bindingSignUp: ActivitySignUpBinding
    private val mAuth = FirebaseAuth.getInstance()
    val userTask = mAuth.currentUser?.reload()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSignUp = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(bindingSignUp.root)
        bindingSignUp.buttonSignUp.setOnClickListener {
            signUpEmail(bindingSignUp.createEmail.text.toString(), bindingSignUp.createPassword.text.toString())
        }
        bindingSignUp.textSignIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
    fun signUpEmail(email: String, password: String){
        if (email.isNotEmpty() && password.isNotEmpty()){
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task->
                if (task.isSuccessful){
                    sendEmailVerification(task.result?.user!!)
                }else{
                    Toast.makeText(this, R.string.no_registr, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun sendEmailVerification(user: FirebaseUser){
        user.sendEmailVerification().addOnCompleteListener { task->
            if (task.isSuccessful){
                Toast.makeText(this, R.string.verification_email, Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, R.string.nepoluchilos_verification_email, Toast.LENGTH_LONG).show()
            }
        }
    }
}


