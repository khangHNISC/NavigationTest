package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(){

    private val vm: SharedVM by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        openBtn.setOnClickListener {
            navController.navigate(R.id.dialogNotifyFragment)
        }

        openBtn2.setOnClickListener {
            val intent = Intent(context, TransActivity::class.java)
            startActivity(intent)
        }

        openNews.setOnClickListener {
            navController.navigate(R.id.newsFragment)
        }

        vm.fakeData.observe(viewLifecycleOwner, Observer {
            if(it.isNotBlank()) print(it)
        })
    }

    override fun onResume() {
        super.onResume()
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

    override fun onDetach() {
        super.onDetach()
    }

    companion object{
        private const val DIALOG = "center_dialog"
    }
    /**
     * -> to new Activity only call on Pause onStop skip destroy view and beyond
     * -> when return to on Resume
     */
}