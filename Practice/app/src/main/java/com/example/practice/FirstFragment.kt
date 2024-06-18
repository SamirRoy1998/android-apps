package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practice.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var b: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentFirstBinding.inflate(inflater, container, false)
        b.firstFrag = this
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.btnNext.setOnClickListener {
            val frag = SecondFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.flFragment, frag).addToBackStack(null).commit()
        }
        b.btnChange.setOnClickListener {
            b.tvFirstFragment.text = "Its works"
        }
    }
}