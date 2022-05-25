package com.timplifier.firebaseauthenticationtest.domain.useCases

import com.timplifier.firebaseauthenticationtest.domain.repositories.StartPhoneNumberVerificationRepository
import javax.inject.Inject

class StartPhoneNumberVerificationUseCase @Inject constructor(
    private val startPhoneNumberVerificationRepository: StartPhoneNumberVerificationRepository
) {
    operator fun invoke(phoneNumber: String) =
        startPhoneNumberVerificationRepository.startVerification(phoneNumber)
}