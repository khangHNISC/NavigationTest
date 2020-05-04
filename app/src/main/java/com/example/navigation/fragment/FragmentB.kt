package com.example.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigation.R
import com.example.navigation.helper.detachFragment
import com.example.navigation.helper.removeFragment
import com.example.navigation.helper.replaceFragment
import kotlinx.android.synthetic.main.fragment_sub.*

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = "it s B"
        btnSet.text = "Remove/Detach"
        btnSet2.text = "Go to C"

        btnSet.setOnClickListener {
            //detach and remove seem to be same
            requireActivity().removeFragment(this)
        }

        btnSet2.setOnClickListener {
            requireActivity().replaceFragment(
                R.id.frag_container,
                FragmentC.newInstance(),
                false
            )
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
        fun newInstance(): FragmentB {
            return FragmentB()
        }
    }

    /**
     * remove and detach wont put Fragment onDestroy or onDetach
     * only back press does
     *
     * both of them destroy the fragment view, but detach keeps the fragment state
     *  in the fragment manager.
     */
}