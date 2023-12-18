package com.pr7.jc_gtnbinar_app.data.repositoryimpl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.pr7.jc_gtnbinar_app.data.model.firebase.User
import com.pr7.jc_gtnbinar_app.data.model.local.LOGINED
import com.pr7.jc_gtnbinar_app.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_app.data.model.local.saveBoolean
import com.pr7.jc_gtnbinar_app.data.model.local.saveString
import com.pr7.jc_gtnbinar_app.domain.repositiory.AuthRepository
import com.pr7.jc_gtnbinar_app.utils.USERS
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    val firebaseDatabase: FirebaseDatabase
):AuthRepository {


    override fun registerUser(
                               name: String,
                               surname: String,
                               gmail: String,
                               password: String): Flow<Boolean?> = callbackFlow {

        firebaseAuth.createUserWithEmailAndPassword(gmail,password).addOnCompleteListener {
            if (it.isSuccessful){

                val databaseReference= firebaseDatabase.getReference().child(USERS)
                val uid=firebaseAuth.currentUser?.uid
                val key=uid
                databaseReference.child(key!!).setValue(User(key = uid, uid = uid, name = name, surname = surname, gmail = gmail, password = password)) .addOnCompleteListener {t->
                    trySend(true)
                }

            }else{
                trySend(false)
            }
        }
        awaitClose()

    }

    override fun loginUser(gmail: String, password: String): Flow<Boolean?> = callbackFlow {

        firebaseAuth.signInWithEmailAndPassword(gmail,password).addOnCompleteListener {
            if (it.isSuccessful){
                saveString(key= USER_UID,value = firebaseAuth.currentUser?.uid)
                saveBoolean(key = LOGINED,value = true)
                trySend(true)
            }else{
                trySend(false)
            }
        }
        awaitClose()

    }
}