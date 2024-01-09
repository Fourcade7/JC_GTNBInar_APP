package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirm
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirmR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlanUseCase @Inject constructor(
    val planRepository: PlanRepository
) {



    fun groupConfirm(
        token: String,
        groupConfirm: GroupConfirm
    ): Flow<Result<GroupConfirmR?>>{
        return planRepository.groupConfirm(token, groupConfirm)
    }

}