package com.pr7.jc_gtnbinar_app.presentation.user.plansopen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jc_gtnbinar_app.presentation.admin.plansopenadmin.plansOpenAdminScreen
import com.pr7.jc_gtnbinar_app.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_app.presentation.user.plansopen.ui.theme.JC_GTNBInar_APPTheme

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

