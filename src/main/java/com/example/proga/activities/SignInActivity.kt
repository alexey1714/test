package com.example.proga.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proga.MainActivity
import com.example.proga.R
import com.example.proga.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    lateinit var bindingSignIn: ActivitySignInBinding
    private val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSignIn = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(bindingSignIn.root)
        checkIfUserIsLogged()
        bindingSignIn.textCreateNewAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        bindingSignIn.buttonSignIn.setOnClickListener {
            signInEmail(bindingSignIn.inputEmail.text.toString(), bindingSignIn.inputPassword.text.toString())
        }
    }
    private fun checkIfUserIsLogged(){
        if (mAuth.currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    fun signInEmail(email: String, password: String){
        if (email.isNotEmpty() && password.isNotEmpty()){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
                if (task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this, R.string.nepoluchilos, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}