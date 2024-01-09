@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.pr7.jc_gtnbinar_appforupload.presentation.admin.homeadmin.bottomscreens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
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
import coil.compose.AsyncImage
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Accept
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.resendadmin.ReSendAdminActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.viewmodels.OrderAdminViewModel
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.greenButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.redButton

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.smallTitle



@Composable
fun acceptAdminScreen(orderAdminViewModel: OrderAdminViewModel) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            largeTitle(text = "Принимать")
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Новые пользователи")
            Spacer(modifier = Modifier.height(10.dp))
            acceptScreen(orderAdminViewModel)

            //customDialog(opendialog, title = "Pr", text = "Загрузка...", confirmButton = {opendialog = it})
            //customprogressDialog(opendialog = opendialog, title = "Pr", text ="Loading..." , confirmButton ={opendialog=it} )
            //customyesornoDialog(opendialog = opendialog, title = "Delete", text ="Deleete or no" , confirmButton = {}, dismissButton ={} )


        }
    }

}

@Composable
private fun acceptScreen(orderAdminViewModel: OrderAdminViewModel) {
    val array = arrayOf(
       Order(
           key = "null",
           userUid = "null",
           userName = "null",
           surName = "null",
           gmail = "null",
           planid = "null",
           planName = "null",
           planPrice = "null",
           imageUrl = "null",
           confirmed = false
       )
    )



    var opendialog by remember {
        mutableStateOf(true)
    }
//    var orderlist by remember {
//        mutableStateOf(orderAdminViewModel.arraylistALlOrders)
//    }

    Column() {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(items = array) { index: Int, item: Order ->
                acceptItem(item)
            }
        }

    }
}


@Composable
private fun acceptItem(order: Order) {
     val context= LocalContext.current
    Column() {
        customCard(onclick = {
            context.startActivity(Intent(context,ReSendAdminActivity::class.java))
        }) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                AsyncImage(
                    model=order.imageUrl,
                    placeholder = painterResource(id = R.drawable.placeholder3),
                    contentDescription = "pr2077",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(145.dp)
                        .weight(0.5f)
                        .background(Color.Transparent), contentScale = ContentScale.Crop,
                    )

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    smallTitle(text = "Имя: ${order.userName}")
                    smallTitle(text = "Фамилия: ${order.surName}")
                    smallTitle(text = "Gmail: ${order.gmail}")
                    smallTitle(text = "Тариф: ${order.planName} ${order.planPrice}")
                    smallTitle(text = if (order.confirmed==null) "Статус: Ожидающий" else if (order.confirmed==true) "Статус: Принял" else if (order.confirmed==false) "Статус: Отклоненный" else "")
                    //smallTitle(text = "Ссылка или новая: ${order.linkorreferal}")
//
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 10.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.weight(1f)) {
                    redButton(onclick = {

                    }, text = "Отказываться")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(Modifier.weight(1f)) {
                    greenButton(onclick = {

                    }, text = "Принимать")
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun acceptPreview() {

    //acceptAdminScreen()


}
