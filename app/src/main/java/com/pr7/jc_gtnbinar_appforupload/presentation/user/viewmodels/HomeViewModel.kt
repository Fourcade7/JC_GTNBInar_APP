package com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.User
import com.pr7.jc_gtnbinar_appforupload.data.model.local.GMAIL
import com.pr7.jc_gtnbinar_appforupload.data.model.local.LOGINED
import com.pr7.jc_gtnbinar_appforupload.data.model.local.NAME
import com.pr7.jc_gtnbinar_appforupload.data.model.local.SURNAME
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.USERNAME
import com.pr7.jc_gtnbinar_appforupload.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.local.saveBoolean
import com.pr7.jc_gtnbinar_appforupload.data.model.local.saveString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.DataUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.HomeUseCase
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val homeUseCase: HomeUseCase
):ViewModel() {


    init {
        if (loadString(TOKEN).toString()!=null){
           getUserData(loadString(TOKEN).toString())

        }
        showlogd("get USERDATA")
    }
    var userRstate:UserR? by mutableStateOf(UserR(data = DataUserR()))
  fun getUserData(token:String)= viewModelScope.launch {

     homeUseCase.getUserData("Bearer $token").collect{result->
         result.onSuccess {
            userRstate=it
          showlogd("role ${it?.data?.role.toString()}")
             if (it?.success==true){
                 saveString(USERNAME,"${it?.data?.last_name} ${it?.data?.first_name}")
             }

         }
         result.onFailure {

         }
     }
  }


}