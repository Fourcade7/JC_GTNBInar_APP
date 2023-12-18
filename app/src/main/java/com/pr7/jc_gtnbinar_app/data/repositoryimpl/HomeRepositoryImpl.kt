package com.pr7.jc_gtnbinar_app.data.repositoryimpl

import android.annotation.SuppressLint
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeRepository
import com.pr7.jc_gtnbinar_app.utils.USERS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(
    val firebaseDatabase: FirebaseDatabase
):HomeRepository {


    override fun getUserData(uid: String): Flow<String> = callbackFlow {
        firebaseDatabase.getReference().child(USERS).child(uid).addValueEventListener(object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
              val name=snapshot.child("name").value as String
              val surname=snapshot.child("surname").value as String
                trySend("$name $surname")

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        awaitClose()
    }
}