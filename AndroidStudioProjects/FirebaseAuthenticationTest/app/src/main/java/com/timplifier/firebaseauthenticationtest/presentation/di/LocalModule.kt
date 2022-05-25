package com.timplifier.firebaseauthenticationtest.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.timplifier.firebaseauthenticationtest.data.local.preferences.AuthorizationPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("timplifier.preferences", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideAuthorizePreferences(preferences: SharedPreferences) =
        AuthorizationPreferences(preferences)
}