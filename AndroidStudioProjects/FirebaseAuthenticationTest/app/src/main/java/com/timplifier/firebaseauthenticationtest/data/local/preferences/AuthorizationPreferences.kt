package com.timplifier.firebaseauthenticationtest.data.local.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class AuthorizationPreferences @Inject constructor(private val preferences: SharedPreferences) {

    var isAuthorized: Boolean
        get() = preferences.getBoolean("isAuthorized", false)
        set(value) = preferences.edit().putBoolean("isAuthorized", value).apply()
    var verificationId: String
        get() = preferences.getString("verificationId", "")!!
        set(value) = preferences.edit().putString("verificationId", value).apply()

}