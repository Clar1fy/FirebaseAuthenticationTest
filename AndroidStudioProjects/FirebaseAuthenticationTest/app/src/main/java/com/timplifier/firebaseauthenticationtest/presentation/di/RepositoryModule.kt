package com.timplifier.firebaseauthenticationtest.presentation.di

import com.timplifier.firebaseauthenticationtest.data.repositories.authentication.StartPhoneNumberVerificationRepositoryImpl
import com.timplifier.firebaseauthenticationtest.domain.repositories.StartPhoneNumberVerificationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindStartPhoneNumberVerification(startPhoneNumberVerificationRepositoryImpl: StartPhoneNumberVerificationRepositoryImpl): StartPhoneNumberVerificationRepository

}