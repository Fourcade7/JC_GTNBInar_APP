package com.pr7.jc_gtnbinar_appforupload.presentation.user.send

import android.app.Activity
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toFile
import coil.compose.AsyncImage
import com.pr7.jc_gtnbinar_appforupload.R
import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.Order
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.backButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.copyContainer
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customCard

import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customTextfield2
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.customhorizontalProgressDialog
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd
import com.pr7.jc_gtnbinar_appforupload.presentation.user.viewmodels.SendViewModel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream


@Composable
fun sendScreen(
    transactionid:Int,
    sendViewModel: SendViewModel
) {
    val context= LocalContext.current as Activity

    var name by remember {
        mutableStateOf("")
    }
    var opendialog by remember {
        mutableStateOf(false)
    }
    var messagedialog by remember {
        mutableStateOf("Загрузка...")
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
            mediumTitle(text = "GTN адрес 125812")
            Spacer(modifier = Modifier.height(10.dp))

            copyContainer(text = "KTSkwAlvgpAlAn9VLUTlxBmwhqCoHwBY")
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Проверка оплаты")
            Spacer(modifier = Modifier.height(10.dp))
            customCard(onclick = { /*TODO*/ }) {
                AsyncImage(
                    model =imageUri?:R.drawable.placeholder2,
                    contentDescription = "pl",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            customButton(text = "Добавить фото ЧЕК"){ launcher.launch("image/*")}
            Spacer(modifier = Modifier.height(10.dp))
            customButton(text = "Отправлять"){


                if (imageUri!=null){
                    opendialog=true


                    val filedir=context.filesDir
                    val file=File(filedir,"image.png")

                    val inputStream=context.contentResolver.openInputStream(imageUri!!)
                    val outputStream=FileOutputStream(file)
                    inputStream!!.copyTo(outputStream)

                    sendViewModel.sendTransactionImage(id = transactionid, file)



                    showlogd("go send image")


                }

            }



//            if (opendialog){
//               customhorizontalProgressDialog(message = messagedialog, progress =sendViewModel.progress.toFloat() , iconvisible =iconshow ) {
//                   GlobalScope.launch {
//                       messagedialog="Загрузка завершена"
//                       iconshow=true
//                       delay(2000)
//                       opendialog=false
//                       iconshow=false
//                       messagedialog="Загрузка..."
//                   }
//               }
//            }

//            if (sendViewModel.sendOrder == true) {
//                LaunchedEffect(sendViewModel.sendOrder) {
//                    messagedialog="Загрузка завершена"
//                    iconshow=true
//                    delay(1500)
//                    opendialog = false
//                    iconshow=false
//                    messagedialog="Загрузка..."
//                    sendViewModel.sendOrder = null
//
//                }
//            }





        }
    }
}





@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun sendScreenPreview() {
   //sendScreen()
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