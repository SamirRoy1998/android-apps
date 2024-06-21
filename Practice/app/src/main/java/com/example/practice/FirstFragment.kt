package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
//    private lateinit var b: FragmentFirstBinding
    private var _b:FragmentFirstBinding? = null
    private val b get() = _b!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        b = FragmentFirstBinding.inflate(inflater, container, false)
        _b = FragmentFirstBinding.inflate(inflater, container, false)
        b.firstFrag = this
        return b.root
    }

    override fun onDestroy() {
        super.onDestroyView()
        _b =null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.btnNext.setOnClickListener {
            val frag = SecondFragment()
            val transaction = parentFragmentManager.beginTransaction()
            val containerId = (activity as MainActivity).getFragmentContainerId()
//            transaction.replace((activity as MainActivity).b.flFragment.id, frag).addToBackStack(null).commit()
            transaction.replace(containerId, frag).addToBackStack(null).commit()
        }
        b.btnChange.setOnClickListener {
            val newText = "Its works"
            b.tvFirstFragment.text = newText
        }
        b.btnF1Quit.setOnClickListener {
            (activity as MainActivity).finish()
        }
    }
}