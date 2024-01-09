package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.data.model.local.MY_PLANS
import com.pr7.jc_gtnbinar_appforupload.data.model.local.ORDERS
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.OrderAdminRepository
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class OrderAdminRepositoryImpl @Inject constructor(
    val firebaseDatabase: FirebaseDatabase,
):OrderAdminRepository {

    override fun confirmOrder(order: Order): Flow<Boolean> = callbackFlow {
        val databaseReference=firebaseDatabase.getReference().child(MY_PLANS)


    }
    override fun readOrdersFromDatabase(): Flow<ArrayList<Order>> = callbackFlow{
        val arrayList=ArrayList<Order>()
        val databaseReference=firebaseDatabase.getReference().child(ORDERS)
        databaseReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                arrayList.clear()
                for (datasnapshot: DataSnapshot in snapshot.children){
                    val order=datasnapshot.getValue(Order::class.java)
                    arrayList.add(order!!)
                }
                //showlogd("OndataChange invoked ${arrayList.size}")

                trySend(arrayList)

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        awaitClose()
    }
}