package com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.bottomscreens

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
import androidx.paging.compose.LazyPagingItems
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.planadd.PlanAdd
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels.PlansAdminViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customTextField

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import kotlinx.coroutines.delay


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun plansAdminScreen(plansAdminViewModel: PlansAdminViewModel,lazyPagingItems: LazyPagingItems<DataX>){
   //val plansAdminViewModel: PlansAdminViewModel = hiltViewModel()

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
    var imagedialog by remember {
        mutableStateOf(R.drawable.checked)
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
                   plansAdminViewModel.addNewPlan(planAdd = PlanAdd(gtn_count = gtnprice.toInt(), name =planname ))
                    opendialog=true

                }
            }

            if (opendialog){
                customprogressDialog(imagedialog,message = titledialog, iconvisible = iconshowdialog) {
                    opendialog=false
                    opendialog=false
                    iconshowdialog=false
                    titledialog="Подождите..."
                }
            }
            if (plansAdminViewModel.planAddRstate?.success == true) {
                LaunchedEffect(plansAdminViewModel.planAddRstate) {
                    titledialog = "Новый тариф успешно добавлен"
                    iconshowdialog = true
                    lazyPagingItems.refresh()
                    delay(1500)
                    opendialog = false
                    iconshowdialog = false
                    titledialog = "Подождите..."
                    planname = ""
                    gtnprice = ""
                    plansAdminViewModel.planAddRstate = null

                }
            }
            if (plansAdminViewModel.planAddRstate?.success == false) {
                LaunchedEffect(plansAdminViewModel.planAddRstate) {
                    titledialog = "Этот тариф был добавлен ранее"
                    imagedialog= R.drawable.error
                    iconshowdialog = true
                    delay(3000)
                    opendialog = false
                    imagedialog= R.drawable.checked
                    iconshowdialog = false
                    titledialog = "Подождите..."
                    planname = ""
                    gtnprice = ""
                    plansAdminViewModel.planAddRstate = null

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