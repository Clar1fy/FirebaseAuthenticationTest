package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.profile

import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebaseauthenticationtest.R
import com.example.firebaseauthenticationtest.databinding.FragmentProfileBinding
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseFragment
import com.timplifier.firebaseauthenticationtest.presentation.extensions.checkWhetherPermissionHasBeenGrantedOrNot
import com.timplifier.firebaseauthenticationtest.presentation.extensions.mainNavControllerNavigation
import com.timplifier.firebaseauthenticationtest.presentation.extensions.navigateSafely
import com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.verifying.VerifyAuthenticationViewModel

class ProfileFragment :
    BaseFragment<FragmentProfileBinding, VerifyAuthenticationViewModel>(R.layout.fragment_profile) {
    override val binding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel: VerifyAuthenticationViewModel by viewModels()
    override fun setupListeners() {
        proceedToHomeFragment()
        setImagePickedFromGallery()
    }

    private fun setImagePickedFromGallery() {
        binding.imProfile.setOnClickListener {


            val activityResultLauncher = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult(),
            ) {
                if (it.resultCode == Activity.RESULT_OK)
                    binding.imProfile.setImageURI(it.data?.data)
            }
            activityResultLauncher.launch(
                checkWhetherPermissionHasBeenGrantedOrNot(
                    requireContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    requireActivity()
                )
            )
        }
    }

    private fun proceedToHomeFragment() {
        binding.apply {
            binding.btnSignIn.setOnClickListener {
                if (etName.text.isNullOrEmpty() || etSurname.text.isNullOrEmpty()) {
                    etName.error = "This field mustn't be empty"
                    etSurname.error = "This field mustn't be empty"


                } else {
                    mainNavControllerNavigation().navigateSafely(R.id.action_authenticationFlowFragment_to_mainFlowFragment)
                }
            }
        }

    }

}