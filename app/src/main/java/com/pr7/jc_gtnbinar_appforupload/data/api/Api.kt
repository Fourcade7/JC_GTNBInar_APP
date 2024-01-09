package com.pr7.jc_gtnbinar_appforupload.data.api

import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUser
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirm
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirmR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.PlansR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAdd
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAddR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.sendtransactionimage.SendTR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser.TransactionUserR
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {


    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",

    )
    @POST("auth/register")
    suspend fun registerUser(@Body registerUser: RegisterUser):Response<RegisterUserR>

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",
        )
    @POST("auth/login")
    suspend fun loginUser(@Body loginUser: LoginUser):Response<LoginUserR>


    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",
    )
    @GET("user")
    suspend fun getUserData(@Header("Authorization") token :String,):Response<UserR>


    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",
    )
    @GET("tariff/list")
    suspend fun getAllPlansforUser(
        @Header("Authorization") token :String,
        @Query("page") page:Int
    ):PlansR


    @GET("tariff")
    suspend fun getAllPlansforAdmin(
        @Header("Authorization") token :String,
        @Query("page") page:Int
    ):PlansR



    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",
    )
    @POST("tariff")
    suspend fun addNewPlan(
        @Header("Authorization") token :String,
        @Body planAdd: PlanAdd
    ):Response<PlanAddR>

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json",
    )
    @POST("group")
    suspend fun groupConfirm(
        @Header("Authorization") token :String,
        @Body groupConfirm: GroupConfirm
    ):Response<GroupConfirmR>



    @GET("transaction/list")
    suspend fun getTransactionsUser(
        @Header("Authorization") token :String,
        @Query("page") page:Int
    ):TransactionUserR



    @Headers(
        "Content-Type: multipart/form-data",
        "Accept: application/json",
    )
    @Multipart
    @POST("transaction/attach/{transaction_id}")
    suspend fun sendTransactionImage(
        @Header("Authorization") token :String,
        @Path("transaction_id") id:Int,
        @Body image: MultipartBody.Part
    ):Response<SendTR>













}