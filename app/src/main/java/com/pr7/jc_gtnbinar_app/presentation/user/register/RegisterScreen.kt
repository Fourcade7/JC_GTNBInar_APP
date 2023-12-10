package com.pr7.jc_gtnbinar_app.presentation.user.register

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jc_gtnbinar_app.presentation.uiutils.backButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customTextfield
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle


@Composable
fun registerScreen() {
    val context= LocalContext.current as Activity
    var name by remember {
        mutableStateOf("")
    }
    var surname by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            backButton {context.finish()}
            Spacer(modifier = Modifier.height(10.dp))
            largeTitle(text = "Регистрация")
            Spacer(modifier = Modifier.height(20.dp))
            customTextfield(text = { name=it }, placeholder = "Имя")
            Spacer(modifier = Modifier.height(10.dp))
            customTextfield(text = { surname=it }, placeholder = "Фамилия")
            Spacer(modifier = Modifier.height(10.dp))
            customTextfield(text = { email=it }, placeholder = "user@gmail.com")
            Spacer(modifier = Modifier.height(10.dp))
            customTextfield(text = { password=it }, placeholder = "Парол")
            Spacer(modifier = Modifier.weight(1f))
            customButton(onclick = { /*TODO*/ }, text = "Регистрация")
        }
    }
}

@Preview
@Composable
private fun registerScreenPreview() {
    registerScreen()
}