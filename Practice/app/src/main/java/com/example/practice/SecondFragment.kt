package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var b: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentSecondBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        b.btnF2Quit.setOnClickListener {
            (activity as MainActivity).finish()
        }
    }
}