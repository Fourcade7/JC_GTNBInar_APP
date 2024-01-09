package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.OrderAdminRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderAdminUseCase @Inject constructor(
    val orderAdminRepository: OrderAdminRepository
) {




    fun readOrdersFromDatabase(): Flow<ArrayList<Order>>{
        return orderAdminRepository.readOrdersFromDatabase()
    }
}