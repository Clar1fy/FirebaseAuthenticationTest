package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.signUp

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebaseauthenticationtest.R
import com.example.firebaseauthenticationtest.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseFragment


class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up) {
    private val firebaseAuth = FirebaseAuth.getInstance()
    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels()
    override fun setupListeners() {
        binding.tv1.setOnClickListener {
            binding.etPhone.append(binding.tv1.text)
            requireActivity()
        }
        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.verifyAuthenticationFragment)
        }
    }

}