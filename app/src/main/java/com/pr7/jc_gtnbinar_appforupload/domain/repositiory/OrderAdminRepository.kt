package com.pr7.jc_gtnbinar_appforupload.domain.repositiory

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import kotlinx.coroutines.flow.Flow

interface OrderAdminRepository {



    fun readOrdersFromDatabase(): Flow<ArrayList<Order>>

    fun confirmOrder(order: Order):Flow<Boolean>

}