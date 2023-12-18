package com.pr7.jc_gtnbinar_app.presentation.user.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_app.domain.usecases.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class AuthViewModel @Inject constructor(
    val authUseCase: AuthUseCase
):ViewModel() {


    var registerUser:Boolean? by mutableStateOf(null)
    var loginUser:Boolean? by mutableStateOf(null)


    fun registerUser(
                     name: String,
                     surname: String,
                     gmail: String,
                     password: String)=viewModelScope.launch{
        authUseCase.registerUser( name = name, surname = surname, gmail = gmail, password = password).collect{
            registerUser=it
        }
    }
    fun loginUser(gmail:String,password:String)=viewModelScope.launch{
        authUseCase.loginUser(gmail, password).collect{
            loginUser =it
        }
    }
}