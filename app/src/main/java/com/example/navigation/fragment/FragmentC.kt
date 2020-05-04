package com.example.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigation.R
import kotlinx.android.synthetic.main.fragment_sub.*

class FragmentC : Fragment(){
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
}

// Activity -> A : false -> B: false -> C: false -> back instance out activity
// false -> true -> true -> pop out Frag by frag and if pop A then out Activity
// false -> false -> true: C -> B then pop

//confuse
// false -> true -> false : C wont destroy even A is created

