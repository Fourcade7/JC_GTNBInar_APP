package com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl

import androidx.core.net.toUri
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.data.model.local.ORDERS
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.sendtransactionimage.SendTR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.SendRepository
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject

class SendRepositoryImpl @Inject constructor(
    val api: Api
):SendRepository {


    override fun sendTranSactionImage(
        token: String,
        id: Int,
        image: File
    ): Flow<Result<SendTR>> =flow<Result<SendTR>> {

        val fileRequestBody = image.asRequestBody("multipart/form-data".toMediaTypeOrNull(),)
        //val fileName: String = "photo_" + System.currentTimeMillis() + ".png"
        val filePart = MultipartBody.Part.createFormData("attachment", image.name, fileRequestBody)

        val response=api.sendTransactionImage("Bearer $token",id, image = filePart)
        if (response.isSuccessful){
            emit(Result.success(response.body()!!))
        }else{
            emit(Result.failure(Exception(response.errorBody()?.string())))
        }

    }.catch {
        emit(Result.failure(Exception(it.message.toString())))
    }

}