package com.pr7.jc_gtnbinar_appforupload.presentation.user.send

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.statusbarcolorchange
import com.pr7.jc_gtnbinar_appforupload.presentation.user.send.ui.theme.JC_GTNBInar_APPTheme
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.SendViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SendActivity : ComponentActivity() {

     val sendViewModel:SendViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var transactionid:Int= intent.getIntExtra("transactionid",0)
        showlogd(transactionid.toString())



        setContent {
            JC_GTNBInar_APPTheme {
                statusbarcolorchange(color = Color.White, darkicons = true)
                sendScreen(
                    transactionid=transactionid,
                    sendViewModel = sendViewModel
                )
            }
        }
    }
}
