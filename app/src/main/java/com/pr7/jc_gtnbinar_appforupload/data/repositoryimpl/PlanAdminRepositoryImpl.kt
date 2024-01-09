package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAdd
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAddR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanAdminRepository
import com.pr7.jc_gtnbinar_appforupload.utils.PLANS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlanAdminRepositoryImpl @Inject constructor(
   val api: Api
) : PlanAdminRepository {


    override fun addNewPlan(token:String,planAdd: PlanAdd): Flow<Result<PlanAddR?>> = flow<Result<PlanAddR?>> {
            val response=api.addNewPlan(token = "Bearer $token", planAdd = planAdd)
            if (response.isSuccessful){
                emit(Result.success(response.body()!!))
            }else{
                emit(Result.failure(Exception(response.errorBody()!!.string())))
            }
    }.catch {
        emit(Result.failure(Exception(it.message.toString())))
    }


}