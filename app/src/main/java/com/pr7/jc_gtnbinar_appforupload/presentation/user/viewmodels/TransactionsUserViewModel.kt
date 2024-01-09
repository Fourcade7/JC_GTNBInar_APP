package com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.api.paging.ResultPagingSourceTransactions
import com.pr7.jc_gtnbinar_appforupload.data.api.paging.ResultPlansAdminPagingSource
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser.DataTR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser.DataXTR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class TransactionsUserViewModel @Inject constructor(
    val api: Api
):ViewModel() {



    fun getAllTransactionsforUser(token:String): Flow<PagingData<DataXTR>> {
        return Pager (config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { ResultPagingSourceTransactions(token = "Bearer $token", api = api) }).flow.cachedIn(viewModelScope)
    }

}