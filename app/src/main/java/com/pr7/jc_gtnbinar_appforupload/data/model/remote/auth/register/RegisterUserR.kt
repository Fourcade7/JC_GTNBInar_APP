package com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register

data class RegisterUserR(
    val `data`: DataX ?=null,
    val error: Error ?=null,
    val success: Boolean ?=null
)