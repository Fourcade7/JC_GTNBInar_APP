package com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan

data class PaginationX(
    val current_page: Int,
    val has_more: Boolean,
    val items_count: Int,
    val per_page: Int
)