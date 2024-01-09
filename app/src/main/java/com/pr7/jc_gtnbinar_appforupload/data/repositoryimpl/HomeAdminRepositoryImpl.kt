package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeAdminRepository
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.utils.PLANS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class HomeAdminRepositoryImpl @Inject constructor(
    val firebaseDatabase: FirebaseDatabase,
    val firebaseStorage: FirebaseStorage
) :HomeAdminRepository {
    override fun readFromDatabase(): Flow<ArrayList<Plan>> = callbackFlow{
        val arrayList=ArrayList<Plan>()
        val databaseReference=firebaseDatabase.getReference().child(PLANS)
        databaseReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                arrayList.clear()
                for (datasnapshot: DataSnapshot in snapshot.children){
                    val plan=datasnapshot.getValue(Plan::class.java)
                    arrayList.add(plan!!)
                }
               // showlogd("OndataChange invoked ${arrayList.size}")

                trySend(arrayList)

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        awaitClose()
    }

    override fun delete(key:String) {
       firebaseDatabase.getReference().child(PLANS).child(key).removeValue()


    }
}