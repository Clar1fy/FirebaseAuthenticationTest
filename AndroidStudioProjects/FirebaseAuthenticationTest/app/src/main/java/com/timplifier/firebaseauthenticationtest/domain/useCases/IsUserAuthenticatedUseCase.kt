package com.timplifier.firebaseauthenticationtest.domain.useCases

import com.timplifier.firebaseauthenticationtest.domain.repositories.AuthRepository
import javax.inject.Inject

class IsUserAuthenticatedUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.isUserAuthenticated()
}