package com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels

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
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirm
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirmR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.PlanUseCase
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlanViewModel @Inject constructor(
    val planUseCase: PlanUseCase,
    val api: Api
):ViewModel()  {


  var groupConfirmR:GroupConfirmR? by mutableStateOf(GroupConfirmR())


    fun groupConrifm(groupConfirm: GroupConfirm)=viewModelScope.launch {
        planUseCase.planRepository.groupConfirm(loadString(TOKEN).toString(),groupConfirm).collect{result->
            result.onSuccess {
                groupConfirmR=it
            }
            result.onFailure {

            }
        }
    }

    fun getAllPlansforUser(token:String): Flow<PagingData<DataX>> {
        return Pager (config = PagingConfig(pageSize = 10, maxSize = 200),
            pagingSourceFactory = { ResultPagingSource(token = "Bearer $token", api = api) }).flow.cachedIn(viewModelScope)
    }




}