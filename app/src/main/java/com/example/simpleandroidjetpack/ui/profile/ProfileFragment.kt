package com.example.simpleandroidjetpack.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.simpleandroidjetpack.R
import com.example.simpleandroidjetpack.ui.login.LoginViewModel
import com.google.android.material.textfield.TextInputLayout

class ProfileFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.authenticationStateEvent.observe(viewLifecycleOwner, { authenticationState ->
            when (authenticationState) {
                is LoginViewModel.AuthenticationState.Authenticated -> {

                }
                is LoginViewModel.AuthenticationState.Unauthenticated -> {
                    findNavController().navigate(R.id.loginFragment)
                }
            }
        })
    }
}