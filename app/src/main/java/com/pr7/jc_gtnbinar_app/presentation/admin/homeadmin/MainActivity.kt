package com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens.BottomBar
import com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens.adminbottomNavGraphSetup

import com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.statusbarcolorchange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                mainAdminScreen()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainAdminScreen(){
    Column {
        val navController = rememberNavController()


        Scaffold(
            bottomBar ={ BottomBar(navHostController = navController)}
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(bottom = 80.dp)) {
                adminbottomNavGraphSetup(navHostController = navController)
            }

        }
    }
}

