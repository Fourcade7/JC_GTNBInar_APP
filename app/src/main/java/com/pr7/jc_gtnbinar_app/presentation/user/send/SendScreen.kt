package com.pr7.jc_gtnbinar_app.presentation.user.send

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pr7.jc_gtnbinar_app.R
import com.pr7.jc_gtnbinar_app.presentation.uiutils.backButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customCard

import com.pr7.jc_gtnbinar_app.presentation.uiutils.customTextfield2
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customprogressDialog
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_app.presentation.user.home.HomeActivity

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun sendScreen() {
    val context= LocalContext.current as Activity

    var name by remember {
        mutableStateOf("")
    }
    var opendialog by remember {
        mutableStateOf(true)
    }
    var messagedialog by remember {
        mutableStateOf("Loading...")
    }
    var iconshow by remember {
        mutableStateOf(false)
    }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            backButton {context.finish()}
            Spacer(modifier = Modifier.height(10.dp))
            largeTitle(text = "Авторизоваться")
            Spacer(modifier = Modifier.height(10.dp))
            mediumTitle(text = "GTN ссилка")
            Spacer(modifier = Modifier.height(10.dp))
            customTextfield2(text = { name=it }, placeholder ="id:aosdeiruy239487" )
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Проверка оплаты")
            Spacer(modifier = Modifier.height(10.dp))
            customCard(onclick = { /*TODO*/ }) {
                AsyncImage(
                    model =imageUri?:R.drawable.placeholder2,
                    contentDescription = "pl",
                    //placeholder = painterResource(id = R.drawable.placeholder2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            customButton(onclick = { launcher.launch("image/*")}, text = "Добавить фото")
            Spacer(modifier = Modifier.height(10.dp))
            customButton(onclick = { opendialog=true
                context.startActivity(Intent(context, HomeActivity::class.java))
                                   }, text = "Отправлять")

            if (opendialog){
                customprogressDialog(message = messagedialog, iconvisible = iconshow, clicable = {
                    GlobalScope.launch {
                        messagedialog="Done"
                        iconshow=true
                        delay(2000)
                        opendialog=false
                        iconshow=false
                        messagedialog="Loading..."
                    }
                }
                )
            }





        }
    }
}





@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun sendScreenPreview() {
   sendScreen()
}

/*
*
* var imageUri by remember {
            mutableStateOf<Uri?>(null)
        }
        val launcher = rememberLauncherForActivityResult(
            contract =
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            imageUri = uri
        }
    AsyncImage(
     model = imageUri,
     contentDescription = null,
     modifier = Modifier
                .padding(4.dp)
                .fillMaxHeight().width(100.dp)
                .clip(RoundedCornerShape(12.dp)),
     contentScale = ContentScale.Crop,
    )
Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "select image")
        }
* */