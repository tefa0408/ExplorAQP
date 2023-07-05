package com.example.ges_touristapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ges_touristapp.databinding.ActivityLoginBinding
import com.example.ges_touristapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}