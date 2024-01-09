package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUserR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AuthUseCase @Inject constructor(
    val authRepository: AuthRepository
) {



    fun registerUser(registerUser: RegisterUser):Flow<Result<RegisterUserR?>>{
        return authRepository.registerUser(registerUser)
    }

    fun loginUser(loginUser: LoginUser): Flow<Result<LoginUserR?>>{
        return authRepository.loginUser(loginUser)
    }
}