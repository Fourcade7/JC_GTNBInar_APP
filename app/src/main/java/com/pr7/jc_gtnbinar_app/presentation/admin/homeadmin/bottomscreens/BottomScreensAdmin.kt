package com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.pr7.jc_gtnbinar_app.R

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