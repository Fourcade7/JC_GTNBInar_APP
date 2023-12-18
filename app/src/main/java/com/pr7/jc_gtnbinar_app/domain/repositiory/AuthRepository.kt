package com.pr7.jc_gtnbinar_app.domain.repositiory

import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.data.model.firebase.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {




    fun registerUser(
                      name: String,
                      surname: String,
                      gmail: String,
                      password: String): Flow<Boolean?>
    fun loginUser(gmail:String,password:String): Flow<Boolean?>
}