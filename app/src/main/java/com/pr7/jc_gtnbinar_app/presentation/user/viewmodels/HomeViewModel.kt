package com.pr7.jc_gtnbinar_app.presentation.user.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_app.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_app.data.model.local.loadBoolean
import com.pr7.jc_gtnbinar_app.data.model.local.loadString
import com.pr7.jc_gtnbinar_app.domain.usecases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val homeUseCase: HomeUseCase
):ViewModel() {


    init {
        getUserData()
    }
    var userdata by mutableStateOf("")
  fun getUserData()= viewModelScope.launch {

      if (loadString(USER_UID) !=null){
          homeUseCase.getUserData(loadString(USER_UID).toString()).collect{
              userdata=it
          }
      }


  }


}