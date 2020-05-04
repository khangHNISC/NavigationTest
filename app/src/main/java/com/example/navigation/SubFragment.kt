package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_sub.*

class SubFragment : Fragment(){

    private val vm: SharedVM by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSet.setOnClickListener {
            vm.setData("123")
        }

        vm.fakeData.observe(viewLifecycleOwner, Observer {
            if(it.isNotBlank()) print(it)
        })
    }
}