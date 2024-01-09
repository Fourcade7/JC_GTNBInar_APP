package com.pr7.jc_gtnbinar_appforupload.presentation.user.home.bottomscreens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.MainActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.user.plansopen.PlansOpenActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.HomeViewModel


@Composable
fun homeScreen(homeViewModel:HomeViewModel){
    val context= LocalContext.current as Activity
    LaunchedEffect(key1 = homeViewModel.userRstate?.data?.role){
        if (homeViewModel.userRstate?.data?.role.toString()=="admin"){
            context.startActivity(Intent(context, MainActivity::class.java))
            context.finish()
        }
        showlogd("count open admin activity")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                smallTitle(text = " ${homeViewModel.userRstate?.data?.last_name} ${homeViewModel.userRstate?.data?.first_name} ")
            }
            largeTitle(text = "Мои тарифы")
            Spacer(modifier = Modifier.height(10.dp))
            mediumTitle(text = "Тарифы")
            Box(modifier = Modifier.fillMaxSize()){
                plansHomeScreen()



                    Row(modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(Color.Transparent)
                        .wrapContentWidth(),

                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.youtube) ,
                            contentDescription = "gtn",
                            modifier = Modifier
                                .size(45.dp)
                                .border(width = 0.dp, shape = CircleShape, color = Color.White)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.gtn) ,
                            contentDescription = "gtn",
                            modifier = Modifier
                                .size(45.dp)

                                .border(width = 0.dp, shape = CircleShape, color = Color.White)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.telegram) ,
                            contentDescription = "gtn",
                            modifier = Modifier
                                .size(45.dp)
                                .border(width = 0.dp, shape = CircleShape, color = Color.White)
                        )

                    }




            }



        }


    }

}


@Composable
private fun  plansHomeScreen(){
    val array= arrayOf(
        Plan(name = "Gold", price = "30.000"),
        Plan(name = "Platinum", price = "60.000"),
        Plan(name = "Simple", price = "10.000"),

    )
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 65.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            itemsIndexed(items = array){index: Int, item: Plan ->
                plansItem(plan = item)
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun plansItem(plan: Plan) {
    val context= LocalContext.current

    Column {

        customCard(onclick = {
            context.startActivity(Intent(context, PlansOpenActivity::class.java))
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
                        smallTitle(text = "${plan.price} GTN",Color.White)
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
}