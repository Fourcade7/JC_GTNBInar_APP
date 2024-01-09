package com.pr7.jc_gtnbinar_appforupload.data.model.remote.user

data class UserR(
    val data: DataUserR?,
    val error: ErrorUserR?=null,
    val success: Boolean?=null
)