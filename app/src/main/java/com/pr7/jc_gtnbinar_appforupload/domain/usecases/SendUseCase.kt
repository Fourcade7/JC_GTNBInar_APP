package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.sendtransactionimage.SendTR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.SendRepository
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Inject

class SendUseCase @Inject constructor(
    val sendRepository: SendRepository
) {




    fun sendTransactionImage(token:String,id:Int,image: File):Flow<Result<SendTR>>{
        return sendRepository.sendTranSactionImage(token, id, image)
    }


}