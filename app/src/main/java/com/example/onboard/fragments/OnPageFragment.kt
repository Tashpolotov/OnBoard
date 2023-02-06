package com.example.onboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboard.R
import com.example.onboard.databinding.FragmentOnPageBinding
import com.example.onboard.ui.OnBoardAdapter

@Suppress("UNREACHABLE_CODE")
class OnPageFragment : Fragment() {

        private lateinit var binding: FragmentOnPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentOnPageBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter(requireActivity())
        adapter.also { it.also { binding.vp2Board.adapter = it } }
        binding.dotsIndicator.attachTo(binding.vp2Board)
    }
}