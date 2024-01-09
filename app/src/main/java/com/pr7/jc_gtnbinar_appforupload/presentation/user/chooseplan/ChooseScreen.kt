package com.pr7.jc_gtnbinar_appforupload.presentation.user.chooseplan

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Plan
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customTextField

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.user.plansopen.PlansOpenActivity

import com.pr7.jc_gtnbinar_appforupload.presentation.user.send.SendActivity


@Composable
fun chooseScreen() {
    val context= LocalContext.current
    var userid by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            Spacer(modifier = Modifier.height(10.dp))
            largeTitle(text = "Добро пожаловать в")
                       largeTitle(text = "GTN BINAR")
            Spacer(modifier = Modifier.height(10.dp))
            mediumTitle(text = "Рефералный ссилка")
            Spacer(modifier = Modifier.height(10.dp))
            customTextField(name=userid,text = {userid=it}, placeholder = "id:userid")
            Spacer(modifier = Modifier.height(15.dp))
            customButton(onclick = {
                context.startActivity(Intent(context,SendActivity::class.java))
             }, text = "Вход")
            Spacer(modifier = Modifier.height(20.dp))
            mediumTitle(text = "Тарифы")
            Spacer(modifier = Modifier.height(10.dp))
            plansScreen()
        }
    }
}


@Composable
private fun plansScreen(){
    val array= arrayOf(
        Plan(name = "Spark", price = "30"),
        Plan(name = "Spark", price = "30"),
        Plan(name = "Spark", price = "30"),
    )
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
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


@Preview
@Composable
private fun authScreenPreview() {
    chooseScreen()
}