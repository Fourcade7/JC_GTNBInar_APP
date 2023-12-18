package com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pr7.jc_gtnbinar_app.R
import com.pr7.jc_gtnbinar_app.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_app.presentation.admin.viewmodels.HomeAdminViewModel
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_app.presentation.uiutils.dropDownMenu
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_app.presentation.user.plansopen.PlansOpenActivity
import kotlinx.coroutines.delay


@Composable
fun homeAdminScreen(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            largeTitle(text = "Админ")
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Тарифы")

            plansScreen()
        }


    }

}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
private fun plansScreen(){

    val homeAdminViewModelh: HomeAdminViewModel = hiltViewModel()
    //val mutableLiveData by homeAdminViewModelh.mlivedata.observeAsState()


    var opendialog by remember {
        mutableStateOf(false)
    }
    var titledialog by remember {
        mutableStateOf("Подождите...")
    }



    Column {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
            itemsIndexed(items = homeAdminViewModelh.arraylistALlPlans!!.reversed()){ index: Int, item: Plan ->
                plansItem(plan = item)
            }
        }

    }

    //opendialog = homeAdminViewModelh.arraylistALlPlans!!.size==0
    LaunchedEffect(key1 = homeAdminViewModelh.arraylistALlPlans){
        if (homeAdminViewModelh.arraylistALlPlans.size==0){
            opendialog=true
            delay(3000)
            opendialog=false
        }else{
            delay(500)
            opendialog=false
        }
    }

    if (opendialog){
         customprogressDialog(message = titledialog, iconvisible = false) {
            opendialog=false

        }
    }

        
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun plansItem(plan: Plan) {
    val homeAdminViewModel: HomeAdminViewModel = hiltViewModel()
    val context= LocalContext.current
    var expandex by remember {
        mutableStateOf(false)
    }

    Column {

        customCard(onclick = {
            context.startActivity(Intent(context, PlansOpenActivity::class.java))
        }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .combinedClickable(
                        onClick = {},
                        onLongClick = {
                            expandex = true

                        }
                    ),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.background1),
                    contentDescription ="bg1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.gtn) ,
                        contentDescription = "gtn",

                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(width = 1.dp, shape = CircleShape, color = Color.White),


                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(horizontalAlignment = Alignment.End) {
                        smallTitle(text = "${plan.price} GTN",Color.White)

                        Column(Modifier.fillMaxWidth()) {
                            mediumTitle(text = plan.name!!, Color.White)
                        }
                        Row (verticalAlignment = Alignment.CenterVertically){
                            smallTitle(text = "Пользователи : 744",Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            dropDownMenu(expanded = expandex, dismiss = {  expandex=false}, onclick = {
                                expandex=false
                                homeAdminViewModel.deletePlan(plan.key.toString())
                            })
                            Icon(
                                painter = painterResource(id = R.drawable.group),
                                contentDescription = "group",
                                modifier = Modifier.size(22.dp),
                                tint = Color.White
                            )


                        }
                    }

                }
            }

        }

    }
}




@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun homeAdminScreenPreview() {
    Column {
      //  homeAdminScreen()

    }

}