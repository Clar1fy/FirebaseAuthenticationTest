package com.timplifier.firebaseauthenticationtest.domain.repositories

interface StartPhoneNumberVerificationRepository {
    fun startVerification(phoneNumber: String)
}