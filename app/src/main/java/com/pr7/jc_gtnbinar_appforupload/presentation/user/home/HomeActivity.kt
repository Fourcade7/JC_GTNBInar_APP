package com.pr7.jc_gtnbinar_appforupload.presentation.user.home

import android.annotation.SuppressLint
import android.content.Intent
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
import com.pr7.jc_gtnbinar_appforupload.data.model.local.LOGINED
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadBoolean
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser.DataXTR
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.MainActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_appforupload.presentation.user.home.bottomscreens.BottomBarUser
import com.pr7.jc_gtnbinar_appforupload.presentation.user.home.bottomscreens.bottomNavGraphSetup
import com.pr7.jc_gtnbinar_appforupload.presentation.user.home.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_appforupload.presentation.user.login.LoginActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.HomeViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.PlanViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.TransactionsUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    val homeViewModel:HomeViewModel by viewModels()
    val planViewModel:PlanViewModel by viewModels()
    val transactionsUserViewModel:TransactionsUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         showlogd(text = loadString(TOKEN).toString())

        if (!loadBoolean(LOGINED)){
            startActivity(Intent(this@HomeActivity,LoginActivity::class.java))
            finish()
        }

        setContent {
            JC_GTNBInar_APPTheme {
                val mlist=  planViewModel.getAllPlansforUser(loadString(TOKEN).toString()).collectAsLazyPagingItems()
                val mlisttransactions=  transactionsUserViewModel.getAllTransactionsforUser(loadString(TOKEN).toString()).collectAsLazyPagingItems()
                statusbarcolorchange(color = Color.White, darkicons = true)
                userMainScreen(homeViewModel = homeViewModel, planViewModel = planViewModel, lazyPagingItems = mlist,mlisttransactions)
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun userMainScreen(
    homeViewModel:HomeViewModel,
    planViewModel: PlanViewModel,
    lazyPagingItems: LazyPagingItems<DataX>,
    lazyPagingItemstr: LazyPagingItems<DataXTR>
) {

    Column {
        val navController = rememberNavController()
        Scaffold(
            bottomBar ={ BottomBarUser(navHostController = navController) }
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)) {

                bottomNavGraphSetup(
                    navHostController = navController,
                    homeViewModel=homeViewModel,
                    planViewModel = planViewModel,
                    lazyPagingItems = lazyPagingItems,
                    lazyPagingItemstr = lazyPagingItemstr
                )
            }

        }
    }
}







