package com.pr7.jc_gtnbinar_app.domain.repositiory

import kotlinx.coroutines.flow.Flow

interface HomeRepository {



    fun getUserData(uid:String):Flow<String>



}