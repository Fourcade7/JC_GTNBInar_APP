package com.pr7.jc_gtnbinar_appforupload.domain.repositiory

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.User
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import kotlinx.coroutines.flow.Flow

interface HomeRepository {





    fun getUserData(token:String):Flow<Result<UserR?>>



}