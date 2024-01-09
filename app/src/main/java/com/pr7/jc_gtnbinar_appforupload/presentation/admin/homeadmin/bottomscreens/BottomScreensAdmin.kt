package com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.bottomscreens

import com.pr7.jc_gtnbinar_appforupload.R

sealed class Screens constructor(
    val route: String,
    val title: String,
    val icon: Int
) {
    object HomeAdmin : Screens(
        route = "homeadmin_screen",
        title = "Главная",
        icon = R.drawable.home
    )
    object PlansAdmin : Screens(
        route = "plans_screen",
        title = "Тарифы",
        icon =R.drawable.strategy
    )
    object AcceptAdmin : Screens(
        route = "accept_screen",
        title = "Принимать",
        icon =R.drawable.useraccept
    )
}