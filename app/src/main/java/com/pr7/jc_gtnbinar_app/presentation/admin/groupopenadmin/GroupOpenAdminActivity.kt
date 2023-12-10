package com.pr7.jc_gtnbinar_app.presentation.admin.groupopenadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jc_gtnbinar_app.presentation.admin.groupopenadmin.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_app.presentation.uiutils.statusbarcolorchange

class GroupOpenAdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                groupsOpenAdminScreen()

            }
        }
    }
}

