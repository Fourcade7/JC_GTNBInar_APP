package com.pr7.jc_gtnbinar_appforupload.domain.repositiory

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAdd
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAddR
import kotlinx.coroutines.flow.Flow

interface PlanAdminRepository {




    fun addNewPlan(token:String,planAdd: PlanAdd):Flow<Result<PlanAddR?>>




}