package com.pr7.jc_gtnbinar_app.domain.usecases

import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeAdminRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeAdminUseCase @Inject constructor(
   val homeAdminRepository: HomeAdminRepository
) {


    fun getAllPlans(): Flow<ArrayList<Plan>> {
        return homeAdminRepository.readFromDatabase()
    }

    fun deletePlan(key:String){
        homeAdminRepository.delete(key)
    }
}