package com.pr7.jc_gtnbinar_appforupload.presentation.user.plansopen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_appforupload.presentation.user.plansopen.ui.theme.JC_GTNBInar_APPTheme

class PlansOpenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                plansOpenScreen()
            }
        }
    }
}

