package com.example.navigation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.helper.addFragment
import com.example.navigation.helper.replaceFragment
import kotlinx.android.synthetic.main.fragment_sub.*

class FragmentA : Fragment(){

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSet.text = "go to B via replace"
        btnSet2.text = "got to B via add"
        textView.text = "It s has to be A"

        btnSet.setOnClickListener {
            requireActivity().replaceFragment(
                R.id.frag_container,
                FragmentB.newInstance(),
                isAddToBackStack
            )
            //#1. this replace replace A with B
        }

        btnSet2.setOnClickListener {
            requireActivity().addFragment(
                R.id.frag_container,
                FragmentB.newInstance(),
                isAddToBackStack
            )
            //#2. this replace put B on top of A
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): FragmentA{
            return FragmentA()
        }

        const val isAddToBackStack = true
    }
}

/**
 *  every time add: OnAttach; on Create; on CreateView ...
 *  every tine remove: OnPause; OnStop; OnDestroyView; OnDestroy; onDetach
 *
 *  replace A with B = remove A then add B
 *  add B ontop of A = A wont Pause B create
 *
 *  replace A with B enables addToBackStack:
 *      1. remove A then add B
 *      2. when pop B remove, A skip attach an onCreate -> CreateView
 *
 *  add B on top enables addToBackStack:
 *      1. add B ontop of A
 *      2. when B remove, A back -> and skip everything (A was not destroyed)
 **/