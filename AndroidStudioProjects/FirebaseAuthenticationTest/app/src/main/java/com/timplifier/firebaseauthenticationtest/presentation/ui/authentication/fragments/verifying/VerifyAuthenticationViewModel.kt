package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.verifying

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.timplifier.firebaseauthenticationtest.data.repositories.authentication.AuthRepositoryImpl
import com.timplifier.firebaseauthenticationtest.data.repositories.authentication.CodeVerificationRepositoryImpl
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VerifyAuthenticationViewModel @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    private val codeVerificationRepositoryImpl: CodeVerificationRepositoryImpl,
    private val authRepositoryImpl: AuthRepositoryImpl
) : BaseViewModel() {
    private var smsCode: String? = null
    fun verifyPhoneNumberWithCode(
        verificationId: String,
        code: String,
    ): PhoneAuthCredential {
        val credential =
            codeVerificationRepositoryImpl.verifyPhoneNumberWithCode(
                verificationId,
                code
            )
        smsCode = credential.smsCode
        return credential

    }

    fun provideCallback(context: Context) = authRepositoryImpl.provideAuthCallback(
        {
            Toast.makeText(
                context,
                "You entered the wrong number", Toast.LENGTH_SHORT
            ).show()
        },
        { Toast.makeText(context, "You exceeded the request limit", Toast.LENGTH_SHORT).show() }, {}
    )

    fun getVerificationId() = codeVerificationRepositoryImpl.getVerificationId()
    fun getForceResendingToken() = authRepositoryImpl.provideResendingToken()
    fun getSmsCode() = smsCode
    fun isUserAuthenticated() = authRepositoryImpl.isUserAuthenticated()
}