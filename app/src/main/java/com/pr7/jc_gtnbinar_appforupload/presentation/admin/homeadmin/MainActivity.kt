package com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.bottomscreens.BottomBar
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.bottomscreens.adminbottomNavGraphSetup

import com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels.HomeAdminViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels.OrderAdminViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels.PlansAdminViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.statusbarcolorchange
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   val  homeAdminViewModel:HomeAdminViewModel by viewModels()
   val  plansAdminViewModel: PlansAdminViewModel by viewModels()
   val  orderAdminViewModel: OrderAdminViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            JC_GTNBInar_APPTheme {
                val mlist=  plansAdminViewModel.getAllPlansforAdmin(loadString(TOKEN).toString()).collectAsLazyPagingItems()
                statusbarcolorchange(color = Color.White, darkicons = true)
                mainAdminScreen(homeAdminViewModel,plansAdminViewModel,orderAdminViewModel,mlist)

            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainAdminScreen(homeAdminViewModel: HomeAdminViewModel,plansAdminViewModel: PlansAdminViewModel,orderAdminViewModel:OrderAdminViewModel, lazyPagingItems: LazyPagingItems<DataX>){
    Column {
        val navController = rememberNavController()


        Scaffold(
            bottomBar ={ BottomBar(navHostController = navController)}
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)) {
                adminbottomNavGraphSetup(
                    navHostController = navController,
                    homeAdminViewModel=homeAdminViewModel,
                    plansAdminViewModel=plansAdminViewModel,
                    orderAdminViewModel=orderAdminViewModel,
                    lazyPagingItems = lazyPagingItems
                    )
            }

        }
    }
}

