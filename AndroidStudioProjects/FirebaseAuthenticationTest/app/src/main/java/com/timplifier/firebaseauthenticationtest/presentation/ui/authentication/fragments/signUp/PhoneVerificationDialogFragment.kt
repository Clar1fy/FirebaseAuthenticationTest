package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.signUp

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebaseauthenticationtest.R
import com.example.firebaseauthenticationtest.databinding.FragmentPhoneVerificationDialogBinding
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseDialogFragment


class PhoneVerificationDialogFragment :
    BaseDialogFragment<FragmentPhoneVerificationDialogBinding>(R.layout.fragment_phone_verification_dialog) {
    override val binding by viewBinding(FragmentPhoneVerificationDialogBinding::bind)
    override fun setupListeners() {
        setupEditPhoneNumberListener()
    }

    private fun setupEditPhoneNumberListener() {
        binding.tvEditPhoneNumber.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }
    }

}