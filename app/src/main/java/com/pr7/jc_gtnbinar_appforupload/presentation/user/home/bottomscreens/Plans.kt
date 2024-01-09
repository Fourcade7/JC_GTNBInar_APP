@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.pr7.jc_gtnbinar_appforupload.presentation.user.home.bottomscreens

import android.app.Activity
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.data.model.local.GMAIL
import com.pr7.jc_gtnbinar_appforupload.data.model.local.NAME
import com.pr7.jc_gtnbinar_appforupload.data.model.local.SURNAME
import com.pr7.jc_gtnbinar_appforupload.data.model.local.TOKEN
import com.pr7.jc_gtnbinar_appforupload.data.model.local.USER_UID
import com.pr7.jc_gtnbinar_appforupload.data.model.local.loadString
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.group.GroupConfirm
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.transactionuser.DataXTR
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.MainActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.admincustomDialog
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customTextField
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customyesornoDialog

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.user.home.HomeActivity

import com.pr7.jc_gtnbinar_appforupload.presentation.user.send.SendActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.PlanViewModel
import kotlinx.coroutines.delay


@Composable
fun plansAllScreen(planViewModel: PlanViewModel,lazyPagingItems: LazyPagingItems<DataX>,navHostController: NavHostController,lazyPagingItemstr: LazyPagingItems<DataXTR>){
    val context= LocalContext.current as Activity
    var name by remember {
        mutableStateOf("")
    }
    var opendialog by remember {
        mutableStateOf(false)
    }



    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            Text(
                text = "Тарифы",
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.inter_extrabold)),
                color = Color(0xFF000000),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.combinedClickable(onClick = {}, onLongClick = {
                    //opendialog=true
                })
            )
            if (opendialog){
                admincustomDialog(name = name, text = {text->
                    name=text
                }) {
//                    if (name=="Ali7809092005"){
//                        context.startActivity(Intent(context, MainActivity::class.java))
//
//                    }
                    context.startActivity(Intent(context, MainActivity::class.java))
                    opendialog=false
                }
            }
            authUserScreen()

           plansScreen(planViewModel,lazyPagingItems,navHostController,lazyPagingItemstr)
        }


    }

}

@Composable
fun authUserScreen() {
    val context= LocalContext.current

    var userid by remember {
        mutableStateOf("")
    }

        Column() {


            Spacer(modifier = Modifier.height(10.dp))
            mediumTitle(text = "Рефералный ссилка")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name=userid,text = {userid=it}, placeholder = "id:userid")
            Spacer(modifier = Modifier.height(15.dp))
            customButton(onclick = {
                context.startActivity(Intent(context, SendActivity::class.java))
            }, text = "Добавлять")
            Spacer(modifier = Modifier.height(20.dp))
            mediumTitle(text = "Тарифы")
            Spacer(modifier = Modifier.height(10.dp))

        }

}



@Composable
private fun plansScreen(planViewModel: PlanViewModel,lazyPagingItems: LazyPagingItems<DataX>,navHostController: NavHostController,lazyPagingItemstr: LazyPagingItems<DataXTR>){


//    var mlist by remember {
//        mutableStateOf(planViewModel.arraylistALlPlans.reversed())
//    }

    val array= arrayOf(
        Plan(key = "0", name = "Pr", price = "Aminov")
    )

    var opendialog by remember {
        mutableStateOf(false)
    }
    var titledialog by remember {
        mutableStateOf("Подождите...")
    }
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){

//            itemsIndexed(items = mlist.itemSnapshotList.items){index: Int, item: DataXTR ->
//                plansItem(plan = item)
//            }


            items(lazyPagingItems.itemCount){
                plansItem(plan = lazyPagingItems[it]!!,planViewModel,navHostController,lazyPagingItemstr)
            }

               lazyPagingItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        showlogd("Loading first plans")
                    }

                    loadState.append is LoadState.Loading -> {
                        showlogd("Loading next plans")
                       
                    }

                    loadState.append is LoadState.Error -> {
                        //You can use modifier to show errorAdd message
                    }
                }
            }
        }


//        LazyColumn(
//            contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
//            verticalArrangement = Arrangement.spacedBy(10.dp)
//        ) {
//            items(
//                count = planViewModel.arraylistALlPlans.size,
//                key = {
//                    planViewModel.arraylistALlPlans[it].price!!.toInt()
//                },
//                itemContent = {index: Int ->
//                    plansItem(plan = planViewModel.arraylistALlPlans[index])
//                }
//            )
//        }



//        LaunchedEffect(key1 = planViewModel.arraylistALlPlans){
//            if (planViewModel.arraylistALlPlans.size==0){
//                opendialog=true
//                delay(3000)
//                opendialog=false
//            }else{
//                delay(500)
//                opendialog=false
//            }
//        }

        if (opendialog){
            customprogressDialog(message = titledialog, iconvisible = false) {
                opendialog=false

            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun plansItem(plan: DataX,planViewModel: PlanViewModel,navHostController: NavHostController,lazyPagingItemstr: LazyPagingItems<DataXTR>) {
    val context= LocalContext.current
    var opendialog by remember {
        mutableStateOf(false)
    }

    var opendialogprogress by remember {
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
    Column {

        customCard(onclick = {
            ///context.startActivity(Intent(context, PlansOpenActivity::class.java))
            opendialog=true
        }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
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

    if (opendialog){
        customyesornoDialog(
            title = "${plan.name} ${plan.gtn_count} GTN",
            message = "Согласны ли вы с этим тарифом?" ,
            dismissButton = {opendialog=false},
            confirmButton = {
                opendialog=false
                opendialogprogress=true
                planViewModel.groupConrifm(GroupConfirm(plan.id))
            }
        )
    }

    if (opendialogprogress){
        customprogressDialog(image = imagedialog,message = titledialog, iconvisible = iconshowdialog) {
            opendialogprogress=false
            iconshowdialog=false
            titledialog="Подождите..."
        }
    }


        LaunchedEffect(planViewModel.groupConfirmR?.success==true) {
            if (planViewModel.groupConfirmR?.success==true){
                showlogd("count ACCEPT OPEN")
                opendialogprogress=false
                iconshowdialog = false
                titledialog = "Подождите..."
                //context.startActivity(Intent(context, HomeActivity::class.java))
                navHostController.navigate(ScreensUser.Accept.route)
                lazyPagingItemstr.refresh()
                planViewModel.groupConfirmR=null
            }

        }
     if (planViewModel.groupConfirmR?.success==false){
        LaunchedEffect(planViewModel.groupConfirmR?.success) {
            if (planViewModel.groupConfirmR?.error?.message=="group.you_already_have_tariff"){
                titledialog = "План у вас уже есть"
            }
            imagedialog=R.drawable.error
            iconshowdialog = true
            delay(3000)
            opendialogprogress = false
            imagedialog=R.drawable.checked
            iconshowdialog = false
            titledialog = "Подождите..."
            planViewModel.groupConfirmR=null
        }
    }



}





//               val intent= Intent(context, SendActivity::class.java)
//                intent.putExtra("useruid", loadString(USER_UID).toString())
//                intent.putExtra("name", loadString(NAME).toString())
//                intent.putExtra("surname", loadString(SURNAME).toString())
//                intent.putExtra("gmail", loadString(GMAIL).toString())
//                intent.putExtra("planid", plan.key)
//                intent.putExtra("planname", plan.name)
//                intent.putExtra("planprice", plan.price)
//                context.startActivity(intent)
