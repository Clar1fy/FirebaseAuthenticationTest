package com.timplifier.firebaseauthenticationtest.domain.repositories

interface AuthRepository {

    fun isUserAuthenticated(): Boolean
}