package com.pr7.jc_gtnbinar_appforupload.presentation.user.home.bottomscreens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.paging.compose.LazyPagingItems
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser.DataXTR
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.HomeViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.PlanViewModel

@Composable
fun RowScope.addItem(
    screens: ScreensUser,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    NavigationBarItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(
                painter = painterResource(id = screens.icon),
                contentDescription = "",
                modifier = Modifier.size(27.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == screens.route } == true,
        onClick = {
            navHostController.navigate(screens.route)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color(0xFF440980),
            selectedTextColor = Color(0xFF440980),
            indicatorColor = Color.White,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        ),



        )
}

@Composable
fun BottomBarUser(navHostController: NavHostController) {

    val screens = listOf(
        ScreensUser.Home,
        ScreensUser.Plans,
        ScreensUser.Accept,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier= Modifier.shadow(elevation = 20.dp, shape = RectangleShape, spotColor = Color.Black, ambientColor = Color.Black) ,
        containerColor = Color.White,
    ) {
        screens.forEach {
            addItem(
                screens = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }

}

@Composable
fun bottomNavGraphSetup(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
    planViewModel: PlanViewModel,
    lazyPagingItems: LazyPagingItems<DataX>,
    lazyPagingItemstr: LazyPagingItems<DataXTR>
) {


    NavHost(navController = navHostController, startDestination =  ScreensUser.Home.route ){
        composable(route = ScreensUser.Home.route){ homeScreen(homeViewModel = homeViewModel) }
        composable(route = ScreensUser.Plans.route){ plansAllScreen(planViewModel = planViewModel,lazyPagingItems,navHostController,lazyPagingItemstr) }
        composable(route = ScreensUser.Accept.route){ acceptCheckScreen(lazyPagingItemstr) }
    }
}
