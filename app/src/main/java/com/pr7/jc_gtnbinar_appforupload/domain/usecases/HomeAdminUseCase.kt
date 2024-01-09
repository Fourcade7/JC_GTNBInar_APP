package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeAdminRepository
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