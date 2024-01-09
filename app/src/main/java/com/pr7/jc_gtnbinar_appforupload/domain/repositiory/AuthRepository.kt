package com.pr7.jc_gtnbinar_appforupload.domain.repositiory

import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUserR
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun registerUser(registerUser: RegisterUser): Flow<Result<RegisterUserR?>>
    fun loginUser(loginUser: LoginUser):  Flow<Result<LoginUserR?>>
}