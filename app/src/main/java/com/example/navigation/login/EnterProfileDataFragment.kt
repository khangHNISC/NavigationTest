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
import kotlinx.android.synthetic.main.fragment_enter_profile.*

class EnterProfileDataFragment : Fragment() {

    private val registrationViewModel by activityViewModels<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        btnNext.setOnClickListener {
            registrationViewModel.collectProfileData("abc", "am cool")
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            registrationViewModel.userCancelledRegistration()
            navController.popBackStack(R.id.loginFragment, false)
        }

        registrationViewModel.registrationState.observe(viewLifecycleOwner, Observer { state ->
            if (state == RegistrationViewModel.RegistrationState.COLLECT_USER_PASSWORD) {
                navController.navigate(R.id.chooseUserPassFragment)
            }
        })
    }
}