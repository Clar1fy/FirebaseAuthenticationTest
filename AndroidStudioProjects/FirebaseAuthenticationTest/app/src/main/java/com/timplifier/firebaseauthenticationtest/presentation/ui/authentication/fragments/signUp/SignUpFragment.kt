package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.signUp

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebaseauthenticationtest.R
import com.example.firebaseauthenticationtest.databinding.FragmentSignUpBinding
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseFragment
import com.timplifier.firebaseauthenticationtest.presentation.extensions.deleteASingleCharacterInEditText
import com.timplifier.firebaseauthenticationtest.presentation.extensions.directionsSafeNavigation
import com.timplifier.firebaseauthenticationtest.presentation.extensions.setOnNumericClickListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up) {
    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by hiltNavGraphViewModels(R.id.authentication_graph)
    override fun setupListeners() {
        addBackspaceListener()
        setupNumericKeyboardListener()
        openPhoneNumberVerificationDialog()
        clearPhoneNumberInputField()
        disableEditTextKeyListener()
    }

    private fun disableEditTextKeyListener() {
        binding.etPhone.keyListener = null
    }

    private fun clearPhoneNumberInputField() {
        binding.ibClearPhoneNumber.setOnClickListener {
            binding.etPhone.text?.clear()
            binding.etPhone.text?.append("+996")
        }
    }

    private fun openPhoneNumberVerificationDialog() {
        binding.btnContinue.setOnClickListener {
            findNavController().directionsSafeNavigation(
                SignUpFragmentDirections.actionSignUpFragmentToPhoneVerificationDialogFragment(
                    binding.etPhone.text.toString()
                )
            )
        }
    }

    private fun addBackspaceListener() {
        binding.ibBackspace.setOnClickListener {
            binding.etPhone.deleteASingleCharacterInEditText()
        }
    }

    private fun setupNumericKeyboardListener() {
        binding.apply {
            tvOne.setOnNumericClickListener(etPhone)
            tvTwo.setOnNumericClickListener(etPhone)
            tvThree.setOnNumericClickListener(etPhone)
            tvFour.setOnNumericClickListener(etPhone)
            tvFive.setOnNumericClickListener(etPhone)
            tvSix.setOnNumericClickListener(etPhone)
            tvSeven.setOnNumericClickListener(etPhone)
            tvEight.setOnNumericClickListener(etPhone)
            tvNine.setOnNumericClickListener(etPhone)
            tvZero.setOnNumericClickListener(etPhone)
        }
    }
}