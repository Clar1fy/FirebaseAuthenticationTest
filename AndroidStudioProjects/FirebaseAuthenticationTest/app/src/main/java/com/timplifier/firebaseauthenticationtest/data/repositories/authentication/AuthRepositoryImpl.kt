package com.timplifier.firebaseauthenticationtest.data.repositories.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.timplifier.firebaseauthenticationtest.data.local.preferences.AuthorizationPreferences
import com.timplifier.firebaseauthenticationtest.domain.repositories.AuthRepository
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val authorizationPreferences: AuthorizationPreferences,
    private var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
) : BaseRepository(), AuthRepository {
    override fun isUserAuthenticated(): Boolean {
        authorizationPreferences.isAuthorized = firebaseAuth.currentUser != null
        return authorizationPreferences.isAuthorized
    }

    fun signUpUser(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
    }

    fun provideAuthCallback() {
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {


                if (e is FirebaseAuthInvalidCredentialsException) {
                } else if (e is FirebaseTooManyRequestsException) {
                }

                // Show a message and update the UI
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {

                Log.e(TAG, "onCodeSent:$verificationId")

                storedVerificationId = verificationId
                resendToken = token
            }

        }

    }

}