package com.example.spacechatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.ui.topFragment.TopFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentSetup()

    }


    private fun fragmentSetup() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.topFragment, TopFragment())
            add(R.id.bottomFragment, BottomFragment())
        }.commit()
    }









}