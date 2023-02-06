package com.example.onboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboard.R
import com.example.onboard.databinding.FragmentFirstListBinding


class FirstListFragment : Fragment() {

    private lateinit var binding:FragmentFirstListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstListBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }
}