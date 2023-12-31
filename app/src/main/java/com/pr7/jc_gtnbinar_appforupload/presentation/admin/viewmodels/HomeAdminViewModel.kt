package com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.HomeAdminUseCase
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeAdminViewModel @Inject constructor(
    val homeAdminUseCase: HomeAdminUseCase
):ViewModel() {

    init {
       // getAllPlans()
       // getAllPlans()
        //showlogd("init invoked")
    }

    var arraylistALlPlans:ArrayList<Plan> by mutableStateOf(ArrayList(emptyList()))
    var mlivedata=MutableLiveData<ArrayList<Plan>>()



//    private val _uiState = MutableStateFlow(ArrayList<Plan>())
//    val uiState = _uiState.asStateFlow()

    fun getAllPlans()=viewModelScope.launch{
        //showlogd("get All Plans")

        homeAdminUseCase.getAllPlans().collect{
            arraylistALlPlans=it
            mlivedata.value=it
        }
    }

    fun deletePlan(key:String){
        homeAdminUseCase.deletePlan(key)
    }


}