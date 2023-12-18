package com.pr7.jc_gtnbinar_app.domain.usecases

import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.domain.repositiory.PlanAdminRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlanAdminUseCase @Inject constructor(
    val planAdminRepository: PlanAdminRepository
) {

     fun insert(plan: Plan):Flow<Boolean?>{
        return  planAdminRepository.insert(plan = plan)
     }




}