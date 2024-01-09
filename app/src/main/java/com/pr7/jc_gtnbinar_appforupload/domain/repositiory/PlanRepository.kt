package com.pr7.jc_gtnbinar_appforupload.domain.repositiory

import androidx.paging.PagingData
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirm
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirmR

import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import kotlinx.coroutines.flow.Flow

interface PlanRepository {




    fun groupConfirm(token:String,groupConfirm: GroupConfirm):Flow<Result<GroupConfirmR?>>


}