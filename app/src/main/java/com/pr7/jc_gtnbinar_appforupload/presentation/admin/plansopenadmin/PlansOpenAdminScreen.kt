package com.pr7.jc_gtnbinar_appforupload.presentation.admin.plansopenadmin

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.presentation.admin.groupopenadmin.GroupOpenAdminActivity
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.backButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.smallTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.verysmallTitle


@Composable
fun plansOpenAdminScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                backButton {}
                Spacer(modifier = Modifier.weight(1f))
                smallTitle(text = "Пользователи : 1523")
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.gtn),
                    contentDescription = "gtn",
                    modifier = Modifier.size(55.dp)
                )
            }

            largeTitle(text = "GOLD 30 GTN")
            Spacer(modifier = Modifier.height(10.dp))
            smallTitle(text = "Группы")
            groupScreen()


        }
    }


}


@Composable
private fun groupScreen() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(bottom = 45.dp, top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
        items(5, key = null) {
            groupItem()
        }
    }
    
}

@Composable
private fun groupItem() {
    val context= LocalContext.current
    customCard(onclick = {
        context.startActivity(Intent(context, GroupOpenAdminActivity::class.java))
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
            ) {
            Image(
                painter = painterResource(id = R.drawable.userperson),
                contentDescription = "uspe",
                modifier = Modifier.size(25.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.userperson),
                contentDescription = "uspe",
                modifier = Modifier.size(25.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.userperson),
                contentDescription = "uspe",
                modifier = Modifier.size(25.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.userperson),
            contentDescription = "uspe",
            modifier = Modifier
                .size(25.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.userperson),
                contentDescription = "uspe",
                modifier = Modifier.size(25.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.userperson),
                contentDescription = "uspe",
                modifier = Modifier.size(25.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.userperson),
                contentDescription = "uspe",
                modifier = Modifier.size(25.dp)
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))
            verysmallTitle(text = "Открыто 6/7", color = Color.Black)
            Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = R.drawable.checked),
                contentDescription = "uspe",
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
       
        
    }
    
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun plansOpenScreenPreview() {
    plansOpenAdminScreen()

}