package com.pr7.jc_gtnbinar_app.presentation.user.home.bottomscreens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.pr7.jc_gtnbinar_app.R
import com.pr7.jc_gtnbinar_app.data.model.remote.response.Plan
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_app.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_app.presentation.user.plansopen.PlansOpenActivity
import com.pr7.jc_gtnbinar_app.presentation.user.send.SendActivity


@Composable
fun homeScreen(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                smallTitle(text = "Имя Фамилия")
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
    var size by remember { mutableStateOf(IntSize.Zero) }
    Column {

        customCard(onclick = {
            context.startActivity(Intent(context, PlansOpenActivity::class.java))
        }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .onSizeChanged {
                        size = it
                    },
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.background1),
                    contentDescription ="bg1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    contentScale = ContentScale.Crop
                )
                showlogd("Box size: ${size.height}")
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.gtn) ,
                        contentDescription = "gtn",
                        modifier = Modifier
                            .size(55.dp)
                            .border(width = 0.dp, shape = CircleShape, color = Color.White)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    mediumTitle(text = plan.name, Color.White)
                    Spacer(modifier = Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.End) {
                        smallTitle(text = "${plan.price} GTN",Color.White)
                        Spacer(modifier = Modifier.height(15.dp))
                        Row (verticalAlignment = Alignment.CenterVertically){
                            smallTitle(text = "Пользователи : 744",Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.group),
                                contentDescription = "group",
                                modifier = Modifier.size(24.dp),
                                tint = Color.White
                            )

                        }
                    }

                }
            }

        }

    }
}