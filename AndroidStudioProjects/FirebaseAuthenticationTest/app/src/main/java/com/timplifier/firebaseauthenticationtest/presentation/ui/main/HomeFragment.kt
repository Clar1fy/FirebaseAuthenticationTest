package com.timplifier.firebaseauthenticationtest.presentation.ui.main

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebaseauthenticationtest.R
import com.example.firebaseauthenticationtest.databinding.FragmentHomeBinding
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseFragment
import com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.verifying.VerifyAuthenticationViewModel


class HomeFragment :
    BaseFragment<FragmentHomeBinding, VerifyAuthenticationViewModel>(R.layout.fragment_home) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: VerifyAuthenticationViewModel by viewModels()

}