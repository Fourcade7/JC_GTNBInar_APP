package com.pr7.jc_gtnbinar_appforupload.presentation.user.login

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.login.LoginUser

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customTextField
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customprogressDialog

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.presentation.user.home.HomeActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.user.register.RegisterActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.AuthViewModel
import kotlinx.coroutines.delay


@Composable
fun loginScreen(authViewModel: AuthViewModel) {

    val context= LocalContext.current as Activity


    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var opendialog by remember {
        mutableStateOf(false)
    }
    var titledialog by remember {
        mutableStateOf("Подождите...")
    }
    var iconshowdialog by remember {
        mutableStateOf(false)
    }
    var imagedialog by remember {
        mutableStateOf(R.drawable.checked)
    }
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            Spacer(modifier = Modifier.height(10.dp))
            largeTitle(text = "Вход")
            Spacer(modifier = Modifier.height(20.dp))
            customTextField(name=email,text = { email=it }, placeholder = "user@gmail.com")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name=password,text = { password=it }, placeholder = "Парол")
            Spacer(modifier = Modifier.weight(1f))
            customButton(onclick = {
                                   context.startActivity(Intent(context,RegisterActivity::class.java))
            }, text = "Регистрация")
            Spacer(modifier = Modifier.height(10.dp))
            customButton(text = "Вход" ){
                if (email.isNotEmpty() && password.isNotEmpty()){
                    opendialog=true
                    focusManager.clearFocus()
                    authViewModel.loginUser(LoginUser(email=email, password=password))
                }
            }


            if (opendialog){
                customprogressDialog(image = imagedialog,message = titledialog, iconvisible = iconshowdialog) {
                    opendialog=false
                    opendialog=false
                    iconshowdialog=false
                    titledialog="Подождите..."
                }
            }




            if (authViewModel.loginUserstate?.success==true) {
                LaunchedEffect(authViewModel.loginUserstate?.success) {
                    opendialog = false
                    iconshowdialog = false
                    titledialog = "Подождите..."
                    context.startActivity(Intent(context,HomeActivity::class.java))
                    authViewModel.loginUserstate=null
                    context.finish()
                }
            } else if (authViewModel.loginUserstate?.success==false){
                LaunchedEffect(authViewModel.loginUserstate) {


                    if (authViewModel.loginUserstate?.error?.email=="These credentials do not match our records."){
                        titledialog = "Эти учетные данные не соответствуют нашим записям."
                    }
                    if (authViewModel.loginUserstate?.error?.email=="The selected email is invalid."){
                        titledialog = "Выбранный адрес электронной почты недействителен."
                    }


                    imagedialog=R.drawable.error
                    iconshowdialog = true
                    delay(3000)
                    opendialog = false
                    imagedialog=R.drawable.checked
                    iconshowdialog = false
                    titledialog = "Подождите..."
                    authViewModel.loginUserstate=null

                }
            }



        }
    }

}

@Preview
@Composable
private fun loginScreenPreview() {
   // loginScreen()
}