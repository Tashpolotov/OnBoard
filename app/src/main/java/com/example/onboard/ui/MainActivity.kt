package com.example.onboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m5_lesson5.utils.Preferences
import com.example.onboard.R
import com.example.onboard.databinding.ActivityMainBinding
import com.example.onboard.fragments.FirstListFragment
import com.example.onboard.fragments.OnPageFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        if (!preferences.isBoardingShowed()){
            supportFragmentManager.beginTransaction().add(R.id.frame_container, OnPageFragment()).commit()
        }else{
            supportFragmentManager.beginTransaction().add(R.id.frame_container, FirstListFragment()).commit()
        }
        setContentView(binding.root)


    }
}