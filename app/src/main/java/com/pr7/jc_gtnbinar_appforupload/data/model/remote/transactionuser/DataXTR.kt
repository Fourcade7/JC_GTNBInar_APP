package com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser

data class DataXTR(
    val created_at: String,
    val description: String,
    val group_id: Int,
    val group_member_id: Int?=null,
    val id: Int,
    val image: String,
    val tariff: TariffTR,
    val group: GroupTR,
    val status: String,
    val type: String,
    val updated_at: String,
    val user_id: Int
)