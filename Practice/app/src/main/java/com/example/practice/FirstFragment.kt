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

    // ↓ Inflate the layout and initialize binding ↓
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        b = FragmentFirstBinding.inflate(inflater, container, false)
        _b = FragmentFirstBinding.inflate(inflater, container, false)
        b.firstFrag = this
        return b.root
        // -> Initializes the binding.
    }

    // ↓ Called when the view hierarchy associated with the fragment is being removed ↓
    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
        // -> Properly nullifies the binding to avoid memory leaks.
    }

    // ↓ Called when the fragment is being destroyed ↓
    override fun onDestroy() {
        super.onDestroy()
    }

    // ↓ Set up button click listeners after the view is created ↓
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
        // -> Sets up the button click listeners.
    }
}