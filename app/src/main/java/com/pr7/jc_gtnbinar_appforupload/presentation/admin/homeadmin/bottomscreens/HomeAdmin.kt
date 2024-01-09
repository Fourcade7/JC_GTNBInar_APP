package com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.bottomscreens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
import androidx.paging.compose.LazyPagingItems
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.local.USERNAME
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels.HomeAdminViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.dropDownMenu
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.user.plansopen.PlansOpenActivity


@Composable
fun homeAdminScreen(homeAdminViewModel: HomeAdminViewModel, lazyPagingItems: LazyPagingItems<DataX>){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                smallTitle(text = loadString(USERNAME).toString())
            }
            largeTitle(text = "Админ")
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Тарифы")

            plansScreen(homeAdminViewModel,lazyPagingItems)
        }


    }

}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
private fun plansScreen(homeAdminViewModel: HomeAdminViewModel, lazyPagingItems: LazyPagingItems<DataX>){

   // val homeAdminViewModel: HomeAdminViewModel = hiltViewModel()
    //val mutableLiveData by homeAdminViewModel.mlivedata.observeAsState()

    val array= arrayOf(
        Plan(key = "0", name = "Pr", price = "Aminov")
    )


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
            items(lazyPagingItems.itemCount){
                plansItem(plan = lazyPagingItems[it]!!)
            }
        }

    }

    //opendialog = homeAdminViewModel.arraylistALlPlans!!.size==0
//    LaunchedEffect(key1 = homeAdminViewModel.arraylistALlPlans){
//        if (homeAdminViewModel.arraylistALlPlans.size==0){
//            opendialog=true
//            delay(3000)
//            opendialog=false
//        }else{
//            delay(500)
//            opendialog=false
//        }
//    }

    if (opendialog){
         customprogressDialog(message = titledialog, iconvisible = false) {
            opendialog=false

        }
    }

        
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun plansItem(plan: DataX) {
   // val homeAdminViewModel: HomeAdminViewModel = hiltViewModel()
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
                        smallTitle(text = "${plan.gtn_count} GTN",Color.White)

                        Column(Modifier.fillMaxWidth()) {
                            mediumTitle(text = plan.name!!, Color.White)
                        }
                        Row (verticalAlignment = Alignment.CenterVertically){
                            smallTitle(text = "Пользователи : 744",Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            dropDownMenu(expanded = expandex, dismiss = {  expandex=false}, onclick = {
                                expandex=false
                                //homeAdminViewModel.deletePlan(plan.key.toString())
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