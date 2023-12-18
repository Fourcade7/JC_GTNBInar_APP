package com.pr7.jc_gtnbinar_app.presentation.admin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.domain.usecases.PlanAdminUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlansAdminViewModel @Inject constructor(
    val planAdminUseCase: PlanAdminUseCase
):ViewModel() {


    var addplantask:Boolean? by mutableStateOf(null)

    fun addnewPlan(plan: Plan)=viewModelScope.launch{
        planAdminUseCase.insert(plan = plan).collect{
            addplantask=it
        }
    }




}