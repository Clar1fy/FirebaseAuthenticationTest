package com.timplifier.firebaseauthenticationtest.data.repositories.authentication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.timplifier.firebaseauthenticationtest.domain.repositories.StartPhoneNumberVerificationRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class StartPhoneNumberVerificationRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

) : StartPhoneNumberVerificationRepository {
    override fun startVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

}