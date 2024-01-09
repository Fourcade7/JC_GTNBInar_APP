package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAdd
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAddR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanAdminRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlanAdminUseCase @Inject constructor(
    val planAdminRepository: PlanAdminRepository
) {

    fun addNewPlan(token:String,planAdd: PlanAdd): Flow<Result<PlanAddR?>> {
        return planAdminRepository.addNewPlan(token,planAdd)
    }



}