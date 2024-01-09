package com.pr7.jc_gtnbinar_appforupload.domain.repositiory

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.sendtransactionimage.SendTR
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import java.io.File

interface SendRepository {





    fun sendTranSactionImage(token:String,id:Int,image: File):Flow<Result<SendTR>>

}