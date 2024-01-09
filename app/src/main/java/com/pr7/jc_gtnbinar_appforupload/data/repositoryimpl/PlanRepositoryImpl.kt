package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import androidx.paging.PagingData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirm
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirmR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanRepository
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.utils.PLANS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlanRepositoryImpl @Inject  constructor(
   val api: Api
):PlanRepository {


   override fun groupConfirm(
      token: String,
      groupConfirm: GroupConfirm
   ): Flow<Result<GroupConfirmR?>> = flow {

      val response=api.groupConfirm("Bearer $token",groupConfirm)
      if (response.isSuccessful){
         emit(Result.success(response.body()))
      }else{
         emit(Result.failure(Exception(response.errorBody()?.string())))
      }

   }.catch {
      emit(Result.failure(Exception(it.message.toString())))
   }


//    override fun readFromDatabase(): Flow<ArrayList<Plan>> = callbackFlow{
//        val arrayList=ArrayList<Plan>()
//        val databaseReference=firebaseDatabase.getReference().child(PLANS)
//        databaseReference.addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                arrayList.clear()
//                for (datasnapshot: DataSnapshot in snapshot.children){
//                    val plan=datasnapshot.getValue(Plan::class.java)
//                    arrayList.add(plan!!)
//                }
//                //showlogd("OndataChange invoked ${arrayList.size}")
//
//                trySend(arrayList)
//
//            }
//
//            override fun onCancelled(errorAdd: DatabaseError) {
//
//            }
//        })
//        awaitClose()
//    }

}