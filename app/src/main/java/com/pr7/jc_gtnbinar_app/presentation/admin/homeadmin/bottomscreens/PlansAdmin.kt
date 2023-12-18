package com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens

import android.annotation.SuppressLint
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.presentation.admin.viewmodels.PlansAdminViewModel
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customTextField

import com.pr7.jc_gtnbinar_app.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.mediumTitle
import kotlinx.coroutines.delay


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun plansAdminScreen(navHostController: NavHostController){
   val plansAdminViewModel: PlansAdminViewModel = hiltViewModel()

    var planname by remember {
        mutableStateOf("")
    }

    var gtnprice by remember {
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
    val focusManager = LocalFocusManager.current



    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            largeTitle(text = "Тарифы")
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Добавить новый тариф")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name = planname,text = {text-> planname=text }, placeholder = "Название тарифа")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name = gtnprice, text = {text->gtnprice=text},"количество ГТН", keyboardType = KeyboardType.Number)
            Spacer(modifier = Modifier.height(15.dp))
            //Spacer(modifier = Modifier.weight(1f))
            customButton( text = "Добавить новый тариф"){
                if (planname.isNotEmpty() && gtnprice.isNotEmpty()){
                    focusManager.clearFocus()
                    plansAdminViewModel.addnewPlan(Plan(name = planname, price = gtnprice))
                    opendialog=true

                }
            }

            if (opendialog){
                customprogressDialog(message = titledialog, iconvisible = iconshowdialog) {
                    opendialog=false
                    opendialog=false
                    iconshowdialog=false
                    titledialog="Подождите..."
                }
            }
            if (plansAdminViewModel.addplantask == true) {
                LaunchedEffect(plansAdminViewModel.addplantask) {
                    titledialog = "Новый тариф успешно добавлен"
                    iconshowdialog = true
                    delay(1500)
                    opendialog = false
                    iconshowdialog = false
                    titledialog = "Подождите..."
                    planname = ""
                    gtnprice = ""
                    plansAdminViewModel.addplantask = null

                }
            }




            
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun planAdminScreenPreview() {
    Column {
       //plansAdminScreen()

    }

}