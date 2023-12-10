package com.pr7.jc_gtnbinar_app.presentation.user.home.bottomscreens

import android.content.Intent
import androidx.compose.foundation.Image
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
import com.pr7.jc_gtnbinar_app.R
import com.pr7.jc_gtnbinar_app.data.model.remote.response.Accept
import com.pr7.jc_gtnbinar_app.presentation.admin.resendadmin.ReSendAdminActivity
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_app.presentation.uiutils.greenButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.redButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.smallTitle


@Composable
fun acceptCheckScreen() {
    var opendialog by remember {
        mutableStateOf(true)
    }

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
            acceptScreen()

            //customDialog(opendialog, title = "Pr", text = "Загрузка...", confirmButton = {opendialog = it})
            //customprogressDialog(opendialog = opendialog, title = "Pr", text ="Loading..." , confirmButton ={opendialog=it} )
            //customyesornoDialog(opendialog = opendialog, title = "Delete", text ="Deleete or no" , confirmButton = {}, dismissButton ={} )


        }
    }

}

@Composable
private fun acceptScreen() {
    val array = arrayOf(


        Accept(imageurl = "https://duckduckgo.com/?q=evertitur", name = "Tommy Mayer", surname = "Susie Hester", linkorreferal = "noster", id = "meliore", gmail = "labores", plan = "taciti"),
        Accept(imageurl = "https://www.google.com/#q=erat", name = "Lenore Golden", surname = "Adolph Potts", linkorreferal = "detraxit", id = "bibendum", gmail = "falli", plan = "mutat"),
        Accept(imageurl = "https://search.yahoo.com/search?p=condimentum", name = "Wilfred Evans", surname = "Pauline Russo", linkorreferal = "instructior", id = "epicuri", gmail = "tamquam", plan = "cetero")
    )
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(items = array) { index: Int, item: Accept ->
                acceptItem(item)
            }
        }

    }
}


@Composable
private fun acceptItem(accept: Accept) {
    val context= LocalContext.current
    Column() {
        customCard(onclick = {

        }) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder3),
                    contentDescription = "pr2077",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(145.dp)
                        .weight(0.5f)
                        .background(Color.Transparent), contentScale = ContentScale.Crop,)

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    smallTitle(text = "Имя: ${accept.name}")
                    smallTitle(text = "Фамилия: ${accept.surname}")
                    smallTitle(text = "Ссылка или новая: ${accept.linkorreferal}")
                    smallTitle(text = "id: ${accept.id}")
                    smallTitle(text = "gmail: ${accept.gmail}")
                    smallTitle(text = "Тариф: ${accept.plan}")
                }
            }


        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun acceptPreview() {

   acceptCheckScreen()


}
