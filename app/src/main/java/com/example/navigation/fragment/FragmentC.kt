package com.example.navigation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.navigation.R
import com.example.navigation.helper.OnBackPressListener
import kotlinx.android.synthetic.main.fragment_sub.*

class FragmentC : Fragment(), OnBackPressListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = "it s C"
        btnSet.text = "PopBackStack"
        btnSet.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
        Log.d("FRAGMANAGER", "${requireActivity().supportFragmentManager.getBackStackEntryAt(1)}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): FragmentC {
            return FragmentC()
        }
    }

    override fun onBackPressed() {
        requireActivity().supportFragmentManager.popBackStack(
            null,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }
}

// Activity -> A : false -> B: false -> C: false -> clear entire bakstack when pop
// false -> true -> true -> pop out Frag by frag and if pop A then out Activity
// false -> false -> true: C -> B then pop

//confuse
// false -> true -> false : C wont destroy even A is created

//follow this
// https://stackoverflow.com/questions/58545500/going-to-first-fragment-from-anywhere-when-pressing-back-button-using-backstack
//suggest let all A B addToBackStack
//then pop everything out manually

/**
 *  When you call addToBackStack(String name) on a FragmentTransaction object
 *  (which you obtain by calling getFragmentManager().beginTransaction()),
 *  then you are adding a FragmentTransaction to your FragmentManagers 'backstack'
 **/