package com.pr7.jc_gtnbinar_app.domain.usecases

import com.pr7.jc_gtnbinar_app.domain.repositiory.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AuthUseCase @Inject constructor(
    val authRepository: AuthRepository
) {


    fun registerUser(
                      name: String,
                      surname: String,
                      gmail: String,
                      password: String): Flow<Boolean?>{
        return authRepository.registerUser(name,surname,gmail, password)
    }
    fun loginUser(gmail:String,password:String): Flow<Boolean?>{
        return authRepository.loginUser(gmail, password)
    }
}