package com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register

data class RegisterUser(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val password_confirmation: String
)