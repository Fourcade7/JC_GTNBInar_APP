package com.pr7.jc_gtnbinar_app.domain.repositiory

import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import kotlinx.coroutines.flow.Flow

interface PlanAdminRepository {

    fun insert(plan: Plan): Flow<Boolean?>




}