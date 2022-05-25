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
        addBackspaceListener()
        setupNumericKeyboardListener()

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.verifyAuthenticationFragment)
        }
    }

    private fun addBackspaceListener() {
        binding.imBackspace.setOnClickListener {
            val cursorPosition = binding.etPhone.selectionStart
            if (cursorPosition > 0)
                binding.etPhone.text?.delete(cursorPosition - 1, cursorPosition)
        }
    }

    private fun setupNumericKeyboardListener() {
        binding.tvOne.setOnClickListener {
            binding.etPhone.append(binding.tvOne.text)
        }
        binding.tvTwo.setOnClickListener {
            binding.etPhone.append(binding.tvTwo.text)
        }
        binding.tvThree.setOnClickListener {
            binding.etPhone.append(binding.tvThree.text)
        }
        binding.tvFour.setOnClickListener {
            binding.etPhone.append(binding.tvFour.text)
        }
        binding.tvFive.setOnClickListener {
            binding.etPhone.append(binding.tvFive.text)
        }
        binding.tvSix.setOnClickListener {
            binding.etPhone.append(binding.tvSix.text)
        }
        binding.tvSeven.setOnClickListener {
            binding.etPhone.append(binding.tvSeven.text)
        }
        binding.tvEight.setOnClickListener {
            binding.etPhone.append(binding.tvEight.text)
        }
        binding.tvNine.setOnClickListener {
            binding.etPhone.append(binding.tvNine.text)
        }
        binding.tvZero.setOnClickListener {
            binding.etPhone.append(binding.tvZero.text)
        }
    }

}