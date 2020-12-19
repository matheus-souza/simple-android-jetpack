package com.example.simpleandroidjetpack.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.simpleandroidjetpack.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.authenticationStateEvent.observe(viewLifecycleOwner, { authenticationState ->
            when (authenticationState) {
                is LoginViewModel.AuthenticationState.InvalidAuthentication -> {
                    val validationFields: Map<String, TextInputLayout> = initValidationFields()

                    authenticationState.fields.forEach { fieldError ->
                        validationFields[fieldError.first]?.error = getString(fieldError.second)
                    }
                }
            }
        })

        buttonLoginSignIn.setOnClickListener {
            val username = inputLoginUsername.text.toString()
            val password = inputLoginPassword.text.toString()

            viewModel.authentication(username, password)
        }
    }

    private fun initValidationFields() = mapOf(
        LoginViewModel.INPUT_USERNAME.first to inputLayoutLoginUsername,
        LoginViewModel.INPUT_PASSWORD.first to inputLayoutLoginPassword
    )
}