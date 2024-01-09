package com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.OrderAdminUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OrderAdminViewModel @Inject constructor(
  val orderAdminUseCase: OrderAdminUseCase
):ViewModel() {

    init {
       // readAllOrdersFromDatabase()
    }


    var arraylistALlOrders:ArrayList<Order> by mutableStateOf(ArrayList(emptyList()))


    fun readAllOrdersFromDatabase()=viewModelScope.launch {
        orderAdminUseCase.readOrdersFromDatabase().collect{
            arraylistALlOrders=it
        }
    }


}