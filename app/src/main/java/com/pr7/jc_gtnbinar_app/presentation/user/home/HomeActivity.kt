package com.pr7.jc_gtnbinar_app.presentation.user.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.pr7.jc_gtnbinar_app.data.model.local.LOGINED
import com.pr7.jc_gtnbinar_app.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_app.data.model.local.loadBoolean
import com.pr7.jc_gtnbinar_app.data.model.local.loadString
import com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens.BottomBar
import com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens.adminbottomNavGraphSetup
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_app.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_app.presentation.user.home.bottomscreens.BottomBarUser
import com.pr7.jc_gtnbinar_app.presentation.user.home.bottomscreens.bottomNavGraphSetup
import com.pr7.jc_gtnbinar_app.presentation.user.home.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_app.presentation.user.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showlogd(text = loadString(USER_UID).toString())
        showlogd(text = loadBoolean(LOGINED).toString())

        if (!loadBoolean(LOGINED)){
            startActivity(Intent(this@HomeActivity,LoginActivity::class.java))
        }
        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                userMainScreen()

            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun userMainScreen() {

    Column {
        val navController = rememberNavController()


        Scaffold(
            bottomBar ={ BottomBarUser(navHostController = navController) }
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)) {

                bottomNavGraphSetup(navHostController = navController)
            }

        }
    }
}







