package com.pr7.jc_gtnbinar_app.presentation.user.chooseplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.pr7.jc_gtnbinar_app.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_app.presentation.user.chooseplan.ui.theme.JC_GTNBInar_APPTheme

class ChooseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                chooseScreen()

            }
        }
    }
}

