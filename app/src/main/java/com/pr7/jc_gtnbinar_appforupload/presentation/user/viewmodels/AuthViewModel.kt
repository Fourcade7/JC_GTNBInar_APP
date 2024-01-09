package com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_appforupload.data.model.local.LOGINED
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.saveBoolean
import com.pr7.jc_gtnbinar_appforupload.data.model.local.saveString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUserR
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.AuthUseCase
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    val authUseCase: AuthUseCase
):ViewModel() {


    var registerUserstate:RegisterUserR? by mutableStateOf(null)
    var loginUserstate:LoginUserR? by mutableStateOf(null)



    fun registerUser(registerUser: RegisterUser)=viewModelScope.launch {
        authUseCase.registerUser(registerUser).collect{result->
            result.onSuccess {
                registerUserstate = it



            }
            result.onFailure {
                //showlogd(it.message.toString())
            }
        }
    }
    fun loginUser(loginUser: LoginUser)=viewModelScope.launch{
        authUseCase.loginUser(loginUser).collect{result->

            result.onSuccess {
                loginUserstate=it
                if (it?.success==true){
                    saveBoolean(LOGINED,true)
                    saveString(TOKEN,it.data?.token.toString())
                }
            }
            result.onFailure {
                //showlogd(it.message.toString())
            }
        }
    }
}