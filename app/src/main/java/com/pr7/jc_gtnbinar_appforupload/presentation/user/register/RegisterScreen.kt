package com.pr7.jc_gtnbinar_appforupload.presentation.user.register

import android.app.Activity
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
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.auth.register.RegisterUser
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.backButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customTextField

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.AuthViewModel
import kotlinx.coroutines.delay


@Composable
fun registerScreen(authViewModel: AuthViewModel) {

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
            backButton {context.finish()}
            Spacer(modifier = Modifier.height(10.dp))
            largeTitle(text = "Регистрация")
            Spacer(modifier = Modifier.height(20.dp))
            customTextField(name=name,text = { name=it }, placeholder = "Имя")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name=surname,text = { surname=it }, placeholder = "Фамилия")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name=email,text = { email=it }, placeholder = "user@gmail.com")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name=password,text = { password=it }, placeholder = "Пароль должен 8 символов")
            Spacer(modifier = Modifier.weight(1f))
            customButton(text = "Регистрация"){
                if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && surname.isNotEmpty()){
                    opendialog=true
                    focusManager.clearFocus()
                    authViewModel.registerUser( RegisterUser(
                       email = email,
                       first_name = name,
                       last_name = surname,
                       password = password,
                       password_confirmation = password
                   ))
                }
            }


            //
            if (opendialog){
                customprogressDialog(image = imagedialog,message = titledialog, iconvisible = iconshowdialog) {
                    opendialog=false
                    opendialog=false
                    iconshowdialog=false
                    titledialog="Подождите..."
                }
            }
            if (authViewModel.registerUserstate?.success==true) {
                LaunchedEffect(authViewModel.registerUserstate) {
                    titledialog = "Регистрация завершена"
                    iconshowdialog = true
                    delay(1500)
                    opendialog = false
                    iconshowdialog = false
                    titledialog = "Подождите..."
                    delay(500)
                    context.finish()
                    //showlogd("count register")
                   authViewModel.registerUserstate=null


                }
            } else if (authViewModel.registerUserstate?.success==false){
                LaunchedEffect(authViewModel.registerUserstate) {

                    if (authViewModel.registerUserstate?.error?.first_name=="The first name field must be at least 3 characters."){
                        titledialog = "Поле имени должно содержать не менее 3 символов."
                    }
                    if (authViewModel.registerUserstate?.error?.last_name=="The last name field must be at least 3 characters."){
                        titledialog = "Поле фамилии должно быть не менее 3 символов."
                    }
                    if (authViewModel.registerUserstate?.error?.first_name=="The first name field must be at least 3 characters." && authViewModel.registerUserstate?.error?.last_name=="The last name field must be at least 3 characters."){
                        titledialog = "Поле имени и фамилии должно содержать не менее 3 символов."
                    }
                    if (authViewModel.registerUserstate?.error?.email=="auth.exists"){
                        titledialog = "Этот адрес электронной почты уже зарегистрирован"
                    }


                    imagedialog=R.drawable.error
                    iconshowdialog = true
                    delay(3000)
                    opendialog = false
                    imagedialog=R.drawable.checked
                    iconshowdialog = false
                    titledialog = "Подождите..."
                   authViewModel.registerUserstate=null

                }
            }

        }
    }
}

@Preview
@Composable
private fun registerScreenPreview() {
    //registerScreen()
}