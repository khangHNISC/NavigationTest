package com.example.navigation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel(){
    enum class RegistrationState {
        COLLECT_PROFILE_DATA,
        COLLECT_USER_PASSWORD,
        REGISTRATION_COMPLETED
    }

    val registrationState =
        MutableLiveData<RegistrationState>(RegistrationState.COLLECT_PROFILE_DATA)

    var authToken = ""
        private set


    fun collectProfileData(name: String, bio: String) {
        // ... validate and store data

        // Change State to collecting username and password
        registrationState.value = RegistrationState.COLLECT_USER_PASSWORD
    }

    fun createAccountAndLogin(username: String, password: String) {
        // ... create account
        // ... authenticate
        //this.authToken = // token
        registrationState.value = RegistrationState.REGISTRATION_COMPLETED
    }

    fun userCancelledRegistration() : Boolean {
        // Clear existing registration data
        registrationState.value = RegistrationState.COLLECT_PROFILE_DATA
        authToken = ""
        return true
    }
}