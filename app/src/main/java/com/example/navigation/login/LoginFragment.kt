package com.example.navigation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.navigation.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(){

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        btnLogin.setOnClickListener {
            viewModel.authenticate("abcd","1234")
        }

        btnRegister.setOnClickListener {
            navController.navigate(R.id.navigation)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            //call back trigger after back press
            viewModel.refuseAuthentication()
            navController.popBackStack(R.id.mainFragment, false)
        }

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> navController.popBackStack()
                LoginViewModel.AuthenticationState.INVALID_AUTHENTICATION -> showErrorMessage()
                else -> showErrorMessage()
            }
        })
    }

    private fun showErrorMessage() {}
}