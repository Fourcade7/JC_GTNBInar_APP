package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.User
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeRepository
import com.pr7.jc_gtnbinar_appforupload.utils.USERS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(

    val api: Api
) : HomeRepository {


    override fun getUserData(token: String): Flow<Result<UserR?>> = flow<Result<UserR?>> {

        val response = api.getUserData(token)
        if (response.isSuccessful) {
            emit(Result.success(response.body()!!))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string())))
        }


    }.catch {
        emit(Result.failure(Exception(it.message.toString())))
    }

//    override fun getUserData(uid: String): Flow<User> = callbackFlow {
//        firebaseDatabase.getReference().child(USERS).child(uid).addValueEventListener(object :ValueEventListener{
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//              val name=snapshot.child("name").value as String
//              val surname=snapshot.child("surname").value as String
//              val gmail=snapshot.child("gmail").value as String
//              trySend(User(name = name, surname = surname, gmail = gmail))
//
//            }
//
//            override fun onCancelled(errorX: DatabaseError) {
//
//            }
//        })
//        awaitClose()
//    }


}