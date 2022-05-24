package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.verifying

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebaseauthenticationtest.R
import com.example.firebaseauthenticationtest.databinding.FragmentVerifyAuthenticationBinding
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseFragment


class VerifyAuthenticationFragment :
    BaseFragment<FragmentVerifyAuthenticationBinding, VerifyAuthenticationViewModel>(R.layout.fragment_verify_authentication) {
    override val binding by viewBinding(FragmentVerifyAuthenticationBinding::bind)
    override val viewModel: VerifyAuthenticationViewModel by viewModels()

}