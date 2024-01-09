package com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.sendtransactionimage.SendTR
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.SendUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


@HiltViewModel
class SendViewModel @Inject constructor(
   val sendUseCase: SendUseCase
):ViewModel() {



        var sendTRlivedata:SendTR by mutableStateOf(SendTR())
    fun sendTransactionImage(id:Int,image: File)=viewModelScope.launch {
        sendUseCase.sendTransactionImage(loadString(TOKEN).toString(), id, image).collect{result->
            result.onSuccess {
            sendTRlivedata=it
            }
            result.onFailure {

            }
        }
    }




}