package com.timplifier.firebaseauthenticationtest.domain.repositories

interface CodeVerificationRepository {
    fun getVerificationId(): String
}