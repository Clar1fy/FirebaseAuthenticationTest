package com.timplifier.firebaseauthenticationtest.data.repositories.authentication

import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.timplifier.firebaseauthenticationtest.data.local.preferences.AuthorizationPreferences
import com.timplifier.firebaseauthenticationtest.domain.repositories.CodeVerificationRepository
import com.timplifier.firebaseauthenticationtest.presentation.base.BaseRepository
import javax.inject.Inject


class CodeVerificationRepositoryImpl @Inject constructor(
    private val authorizationPreferences: AuthorizationPreferences
) : BaseRepository(), CodeVerificationRepository {
    fun verifyPhoneNumberWithCode(
        verificationId: String?,
        code: String,
    ): PhoneAuthCredential {
        return getPhoneAuthCredential(verificationId!!, code)

    }

//    fun cast(){
//        val nonAnActualActivity = NonAnActualActivity ()
//        nonAnActualActivity as AppCompatActivity
//    }

    override fun getVerificationId() = authorizationPreferences.verificationId

    private fun getPhoneAuthCredential(verificationId: String?, code: String) =
        PhoneAuthProvider.getCredential(verificationId.toString(), code)
}