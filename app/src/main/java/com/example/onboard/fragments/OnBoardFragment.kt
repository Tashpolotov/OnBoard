package com.example.onboard.fragments

import android.annotation.SuppressLint
import android.graphics.ColorSpace.Model
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import com.example.m5_lesson5.utils.A
import com.example.onboard.R
import com.example.onboard.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentOnBoardBinding.inflate(LayoutInflater.from(context), container, false)
        initView()

        return binding.root
    }

    @SuppressLint("UseRequireInsteadOfGet", "CommitTransaction")
    private fun initView() {
        arguments.let {
            val data = it?.getSerializable("board") as com.example.onboard.ui.Model
            binding.tvTitleBoard.text = data.title
            binding.tvDescBoard.text = data.description
            binding.tvStazam.text = data.stazam
            data.img?.let { it1 -> binding.imgBoard.setImageResource(it1) }
            binding.btnGetStarted.isVisible = data.isLast==true

            if (data.isLast==false){
                data.bg?.let { it1 -> binding.container.setBackgroundResource(it1) }
            }else{
                data.bg?.let { it1 -> binding.container.setBackgroundResource(it1) }
            }
        }

        binding.btnGetStarted.setOnClickListener{
            val newFragment: Fragment = FirstListFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            val fragmentManager =
                fragmentManager
            fragmentManager!!.beginTransaction().replace(R.id.frame_container, newFragment).commit()
            A.providePrefs(requireContext()).setBoardingShowed(true)
        }
    }

}