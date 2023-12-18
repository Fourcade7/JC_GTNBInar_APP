package com.pr7.jc_gtnbinar_app.domain.repositiory

import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import kotlinx.coroutines.flow.Flow

interface HomeAdminRepository {

    fun readFromDatabase(): Flow<ArrayList<Plan>>
    fun delete(key:String)
}