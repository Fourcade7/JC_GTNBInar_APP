package com.pr7.jc_gtnbinar_appforupload.presentation.user.home.bottomscreens

import com.pr7.jc_gtnbinar_appforupload.R

sealed class ScreensUser constructor(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : ScreensUser(
        route = "homea_screen",
        title = "Главная",
        icon = R.drawable.home
    )
    object Plans : ScreensUser(
        route = "plans_screen",
        title = "Тарифы",
        icon = R.drawable.strategy
    )
    object Accept : ScreensUser(
        route = "accept_screen",
        title = "Принимать",
        icon = R.drawable.useraccept
    )
}