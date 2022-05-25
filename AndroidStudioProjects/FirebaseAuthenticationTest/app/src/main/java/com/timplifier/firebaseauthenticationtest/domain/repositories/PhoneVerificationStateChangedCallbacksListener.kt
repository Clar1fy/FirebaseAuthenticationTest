package com.timplifier.firebaseauthenticationtest.domain.repositories

interface PhoneVerificationStateChangedCallbacksListener {
    fun onPhoneVerificationStateCompleted()
    fun onPhoneVerificationStateFailed(error: String)
    fun onPhoneVerificationStateCodeDetected(verificationCode: String)
    fun onPhoneCodeVerificationFailed(error: String)
    fun onCodeSent(verificationId: String?, token: String?)
}