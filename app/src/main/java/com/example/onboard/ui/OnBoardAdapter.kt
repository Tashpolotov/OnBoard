package com.example.onboard.ui

import android.view.Display.Mode
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onboard.R
import com.example.onboard.fragments.OnBoardFragment
import dagger.hilt.android.qualifiers.ApplicationContext

class OnBoardAdapter (@ApplicationContext fragment: FragmentActivity): FragmentStateAdapter(fragment){

    private val listBoarding = arrayOf(
        Model(
            "STAZAM", R.drawable.pana,
            "Welcome To Stazam",
            "Easily Organise your day to day activities for Maximum productivity",
            false
        ),
        Model(
            "STAZAM", R.drawable.bro,
            "Set Alarms",
            "Set up Alarms daily for Keeping regular schedules", false
        ),
        Model(
            "STAZAM", R.drawable.amico,
            "Create Event Reminder",
            "Set up reminders, that will keep your most important priorities top of mind",
            false
        ),
        Model(
            "STAZAM", R.drawable.rafiki,
            "Taking Notes",
            "Taking Notes and making important to-do lists on the go",
            true
        )
    )



    override fun getItemCount(): Int= listBoarding.size

    override fun createFragment(position: Int): Fragment {
        val data = bundleOf("board" to listBoarding[position])
        val fragment = OnBoardFragment()
        fragment.arguments = data
        return fragment

    }

}