package com.example.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.fragment.FragmentA
import com.example.navigation.helper.replaceFragment

class TransActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trans)

        if (savedInstanceState == null) {
            replaceFragment(
                R.id.frag_container,
                FragmentA.newInstance(),
                false
            )
        }
    }
}