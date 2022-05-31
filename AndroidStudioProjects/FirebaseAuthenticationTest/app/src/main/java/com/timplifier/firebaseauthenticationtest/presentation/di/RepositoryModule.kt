package com.timplifier.firebaseauthenticationtest.presentation.di

import com.timplifier.firebaseauthenticationtest.data.repositories.authentication.AuthRepositoryImpl
import com.timplifier.firebaseauthenticationtest.data.repositories.authentication.CodeVerificationRepositoryImpl
import com.timplifier.firebaseauthenticationtest.domain.repositories.AuthRepository
import com.timplifier.firebaseauthenticationtest.domain.repositories.CodeVerificationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindCodeVerificationRepository(codeVerificationRepositoryImpl: CodeVerificationRepositoryImpl): CodeVerificationRepository
}