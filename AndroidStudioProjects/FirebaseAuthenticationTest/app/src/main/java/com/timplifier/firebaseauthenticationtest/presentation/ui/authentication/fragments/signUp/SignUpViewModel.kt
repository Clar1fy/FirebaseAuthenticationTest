package com.timplifier.firebaseauthenticationtest.presentation.ui.authentication.fragments.signUp

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.*
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseViewModel
import java.util.concurrent.TimeUnit

class SignUpViewModel constructor() : BaseViewModel() {
    private val auth = FirebaseAuth.getInstance()
    fun startPhoneNumberVerification(
        phoneNumber: String,
        firebaseAuth: FirebaseAuth,
        activity: FragmentActivity,
        callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    ) {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun verifyPhoneNumberUsingCode(verificationId: String, smsCode: String) {
        val credential =
            PhoneAuthProvider.getCredential(verificationId, smsCode)
        signInWithPhoneAuthCredential(credential)
    }

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential, context: Context? = null) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    val user = task.result?.user
                } else
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(
                            context,
                            "The verification code entered was invalid",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

            }


    }

    fun resendVerificationCode(
        phoneNumber: String,
        token: PhoneAuthProvider.ForceResendingToken,
        activity: FragmentActivity,
        callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    ) {
        val options = PhoneAuthOptions.newBuilder()
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .setForceResendingToken(token)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}