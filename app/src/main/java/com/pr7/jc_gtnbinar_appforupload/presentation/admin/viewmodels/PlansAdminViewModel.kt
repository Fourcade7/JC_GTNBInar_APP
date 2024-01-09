package com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.api.paging.ResultPagingSource
import com.pr7.jc_gtnbinar_appforupload.data.api.paging.ResultPlansAdminPagingSource
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAdd
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAddR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.DataUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.PlanAdminUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlansAdminViewModel @Inject constructor(
    val planAdminUseCase: PlanAdminUseCase,
    val api: Api
):ViewModel() {


    var planAddRstate:PlanAddR? by mutableStateOf(PlanAddR())

    fun addNewPlan(planAdd: PlanAdd)=viewModelScope.launch{

        planAdminUseCase.addNewPlan(loadString(TOKEN).toString(),planAdd).collect{result->
            result.onSuccess {
                planAddRstate=it
            }
            result.onFailure {

            }
        }
    }



    fun getAllPlansforAdmin(token:String): Flow<PagingData<DataX>> {
        return Pager (config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { ResultPlansAdminPagingSource(token = "Bearer $token", api = api) }).flow.cachedIn(viewModelScope)
    }




}