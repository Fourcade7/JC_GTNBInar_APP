package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.model.local.LOGINED
import com.pr7.jc_gtnbinar_appforupload.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_appforupload.data.model.local.saveBoolean
import com.pr7.jc_gtnbinar_appforupload.data.model.local.saveString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUserR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.AuthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import javax.inject.Inject
import kotlin.Exception

class AuthRepositoryImpl @Inject constructor(

    val api: Api
):AuthRepository {


    override fun registerUser(registerUser: RegisterUser) = flow<Result<RegisterUserR>> {


            val response=api.registerUser(registerUser = registerUser)
            if (response.isSuccessful){
                emit(Result.success(response.body()!!))
            }else{
                emit(Result.failure(Exception(response.errorBody()!!.string())))
            }



    }.catch {
        emit(Result.failure(Exception(it.message.toString())))
    }

    override fun loginUser(loginUser: LoginUser)= flow<Result<LoginUserR?>> {

        val response=api.loginUser(loginUser = loginUser)
        if (response.isSuccessful){
            emit(Result.success(response.body()!!))
        }else{
            emit(Result.failure(Exception(response.errorBody()!!.string())))
        }

    }.catch {
        emit(Result.failure(Exception(it.message.toString())))
    }

//    override fun loginUser(gmail: String, password: String): Flow<Boolean?> = callbackFlow {
//
//        firebaseAuth.signInWithEmailAndPassword(gmail,password).addOnCompleteListener {
//            if (it.isSuccessful){
//                saveString(key= USER_UID,value = firebaseAuth.currentUser?.uid)
//                saveBoolean(key = LOGINED,value = true)
//                trySend(true)
//            }else{
//                trySend(false)
//            }
//        }
//        awaitClose()
//
//    }
}