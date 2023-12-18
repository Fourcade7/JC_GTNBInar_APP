package com.pr7.jc_gtnbinar_app.data.repositoryimpl

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.domain.repositiory.PlanAdminRepository
import com.pr7.jc_gtnbinar_app.utils.PLANS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class PlanAdminRepositoryImpl @Inject constructor(
    val firebaseDatabase: FirebaseDatabase,
    val firebaseStorage: FirebaseStorage
) : PlanAdminRepository {
    override fun insert(plan: Plan):Flow<Boolean?> = callbackFlow {

        val databaseReference= firebaseDatabase.getReference().child(PLANS)
        val key=databaseReference.push().key.toString()
        databaseReference
            .child(key).setValue(Plan(key = key, name = plan.name, price = plan.price))
            .addOnCompleteListener {t->

               trySend(t.isSuccessful)
            }
        awaitClose()
    }


}