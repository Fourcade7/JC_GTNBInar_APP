package com.pr7.jc_gtnbinar_appforupload.presentation.user.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_appforupload.presentation.user.login.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    val authViewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                loginScreen(authViewModel)
            }
        }
    }
}

