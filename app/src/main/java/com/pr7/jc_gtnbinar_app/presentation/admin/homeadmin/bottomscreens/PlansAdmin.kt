package com.pr7.jc_gtnbinar_app.presentation.admin.homeadmin.bottomscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customButton
import com.pr7.jc_gtnbinar_app.presentation.uiutils.customTextfield
import com.pr7.jc_gtnbinar_app.presentation.uiutils.largeTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.mediumTitle
import com.pr7.jc_gtnbinar_app.presentation.uiutils.smallTitle


@Composable
fun plansAdminScreen(){
    var planname by remember {
        mutableStateOf("asdf")
    }
    var gtnprice by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            largeTitle(text = "Тарифы")
            Spacer(modifier = Modifier.height(15.dp))
            mediumTitle(text = "Добавить новый тариф")
            Spacer(modifier = Modifier.height(10.dp))
            customTextfield(text = {text-> planname=text }, "Название тарифа")
            Spacer(modifier = Modifier.height(10.dp))
            customTextfield(text = {text->gtnprice=text},"количество ГТН", keyboardType = KeyboardType.Number)
            Spacer(modifier = Modifier.height(15.dp))
            //Spacer(modifier = Modifier.weight(1f))
            customButton(onclick = {

            }, text = "Добавить новый тариф")




            
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun planAdminScreenPreview() {
    Column {
       plansAdminScreen()

    }

}