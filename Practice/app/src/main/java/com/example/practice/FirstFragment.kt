package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            val frag = SecondFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.flFragment, frag).addToBackStack(null).commit()
        }
        return view
    }
}