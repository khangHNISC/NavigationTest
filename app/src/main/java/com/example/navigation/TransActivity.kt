package com.example.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.fragment.FragmentA
import com.example.navigation.helper.OnBackPressListener
import com.example.navigation.helper.findFragmentById
import com.example.navigation.helper.replaceFragment

class TransActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trans)

        if (savedInstanceState == null) {
            replaceFragment(
                R.id.frag_container,
                FragmentA.newInstance(),
                false, "FragContainer To A"
            )
        }
    }

    override fun onBackPressed() {
        val curFrag = findFragmentById(R.id.frag_container)
        if ((curFrag as? OnBackPressListener) != null) {
            curFrag.onBackPressed()
        }else{
            super.onBackPressed()
        }
    }
}