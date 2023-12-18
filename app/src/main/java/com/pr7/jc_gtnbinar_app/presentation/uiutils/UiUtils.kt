@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.pr7.jc_gtnbinar_app.presentation.uiutils
import android.content.Intent
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pr7.jc_gtnbinar_app.R


@Composable
fun dropDownMenu(expanded:Boolean,onclick: () -> Unit,dismiss: () -> Unit ) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { dismiss.invoke() },
        offset = DpOffset(x = (20).dp, y = (-50).dp),
        modifier = Modifier.background(Color.White)
    ) {

        DropdownMenuItem(
            text = {
                Row(modifier = Modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painter = painterResource(id = R.drawable.trash),
                        contentDescription ="search" ,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(5.dp),
                        tint =  Color.Red
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    smallTitle(text = "Удалить")
                }
            },
            onClick = {
                onclick.invoke()
            }
        )
    }
}

@Composable
fun customCard(onclick: () -> Unit,color: Color= Color.White,content:@Composable ColumnScope.()->Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 15.dp,
                shape = RectangleShape,
                spotColor = Color.Blue,
                ambientColor = Color.Red
            ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
              onclick.invoke()
        },
        colors = CardDefaults.cardColors(color),
    ) {
        content()
    }
}

@Composable
fun backButton(onclick: () -> Unit) {
    Card(
        modifier = Modifier.size(38.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = {
        onclick()
        },
        colors = CardDefaults.cardColors(Color(0xFFE8E7E9)),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrowleft),
                contentDescription = "logo2",
                modifier = Modifier
                    .size(13.dp)
            )
        }
    }
}

@Composable
fun customprogressDialog(

    image:Int=R.drawable.checked,
    message: String,
    iconvisible:Boolean,
    clicable:()->Unit
) {



        AlertDialog(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(Color.White), // corner rounded//not working
            onDismissRequest = {
               clicable()
            },
            containerColor = Color.White,
            confirmButton = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (iconvisible){
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "checked",
                            modifier = Modifier.size(55.dp)
                        )
                    }else{

                        CircularProgressIndicator(
                            modifier = Modifier.size(50.dp),
                            color = Color(0xFF440980),
                            strokeWidth = 10.dp,
                            strokeCap = StrokeCap.Round
                        )
                    }


                    Spacer(modifier = Modifier.height(15.dp))
                    mediumTitle(text = message)
                }
            },


            )

}


@Composable
fun customyesornoDialog(
    opendialog: Boolean,
    title: String,
    text: String,
    confirmButton: (Boolean) -> Unit,
    dismissButton: (Boolean) -> Unit
) {
    var opendialogd by remember {
        mutableStateOf(opendialog)
    }
    if (opendialogd) {
        AlertDialog(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(Color.White), // corner rounded//not working
            onDismissRequest = {
                opendialogd = false
            },
            containerColor = Color.White,
            text = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        tint = Color.Black,
                        modifier = Modifier.size(35.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    mediumTitle(text = title)
                }
            },
            confirmButton = {
                greenButton(onclick = {
                    opendialogd = false
                    confirmButton.invoke(false)

                }, text = "Да")

            },
            dismissButton = {
                redButton(onclick = {
                    opendialogd = false
                    dismissButton.invoke(false)
                }, text = "Нет")
            },

            )
    }
}

@Composable
fun customDialog(
    opendialog: Boolean,
    title: String,
    text: String,
    confirmButton: (Boolean) -> Unit
) {
    var opendialogd by remember {
        mutableStateOf(opendialog)
    }
    if (opendialogd) {
        AlertDialog(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(Color.White), // corner rounded//not working
            onDismissRequest = {
                opendialogd = false
            },
            containerColor = Color.White,
            text = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.checked),
                        contentDescription = "checked",
                        modifier = Modifier.size(35.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                        color = Color(0xFF440980),
                        strokeWidth = 10.dp,
                        strokeCap = StrokeCap.Round
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    mediumTitle(text = text)
                }
            },
            confirmButton = {
                customButton(onclick = {
                    opendialogd = false
                    confirmButton.invoke(false)

                }, text = "Да")

            },


            )
    }
}




@Composable
fun customTextfield2(
    text: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var textfieldname by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(15.dp, shape = RectangleShape, spotColor = Color.Blue),
        value = textfieldname,
        onValueChange = {
            textfieldname = it
            text.invoke(it)
        },
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            focusedLabelColor = Color.Blue,
            unfocusedLabelColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            containerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = Color.Black,
            unfocusedPlaceholderColor = Color(0xFF868588)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = "copy",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Black
                )
            }

        },
        maxLines = 1,
        singleLine = true

        )

}

@Composable
fun customTextField(
    name:String,
    text: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    val focusRequester:FocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(15.dp, shape = RectangleShape, spotColor = Color.Blue),
        value = name,
        onValueChange = {
            text.invoke(it)

        },
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            focusedLabelColor = Color.Blue,
            unfocusedLabelColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            containerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = Color.Black,
            unfocusedPlaceholderColor = Color(0xFF868588)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

        maxLines = 1,
        singleLine = true
    )

}


@Composable
fun largeTitle(text: String) {
    Text(
        text = text,
        fontSize = 28.sp,
        fontFamily = FontFamily(Font(R.font.inter_extrabold)),
        color = Color(0xFF000000),
        fontWeight = FontWeight.Bold,


        )
}

@Composable
fun mediumTitle(text: String,color: Color= Color.Black) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.inter_extrabold)),
        color = color,
        fontWeight = FontWeight.Bold,
        )
}
@Composable
fun verysmallTitle(text: String,color: Color) {
    Text(
        text = text,
        fontSize = 10.sp,
        fontFamily = FontFamily(Font(R.font.inter_light)),
        color = color,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center

        )
}

@Composable
fun smallTitle(text: String,color: Color= Color.Black) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_light)),
        color = color,
        fontWeight = FontWeight.Bold,


        )
}

@Composable
fun customButton(text: String,onclick: () -> Unit ) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        onClick = {
            onclick.invoke()
        },
        shape = RoundedCornerShape(7.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF440980))
    ) {
        Text(text = text, color = Color.White)
    }

}

@Composable
fun greenButton(onclick: () -> Unit, text: String) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp),
        onClick = {
            onclick()
        },
        shape = RoundedCornerShape(7.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF06A864))
    ) {
        Text(text = text, color = Color.White)
    }

}

@Composable
fun redButton(onclick: () -> Unit, text: String) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp),
        onClick = {
            onclick()
        },
        shape = RoundedCornerShape(7.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFA80637))
    ) {
        Text(text = text, color = Color.White)
    }

}


@Composable
fun statusbarcolorchange(color: Color, darkicons: Boolean) {
    // WindowCompat.setDecorFitsSystemWindows(window, false)

    //val systemUiController = rememberSystemUiController()
    //systemUiController.isStatusBarVisible = false
    val systemUiController = rememberSystemUiController()

    SideEffect {
        //JC_YaTaxi_PRv1Theme {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = darkicons,

            )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Preview
@Composable
fun customButtonPreview() {
    Column(modifier = Modifier.padding(10.dp)) {
        customButton(onclick = { }, text = "Send")
        Spacer(modifier = Modifier.height(10.dp))
        greenButton(onclick = { /*TODO*/ }, text = "Accept")
        Spacer(modifier = Modifier.height(10.dp))
        redButton(onclick = { /*TODO*/ }, text = "Decline")
        Spacer(modifier = Modifier.height(10.dp))
        largeTitle(text = "Register")
        Spacer(modifier = Modifier.height(10.dp))
        mediumTitle(text = "Register")
        Spacer(modifier = Modifier.height(10.dp))
        smallTitle(text = "Register")
        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(10.dp))

    }

}

fun showlogd(text: String) {
    Log.d("PR77777", "showlogd: $text")
}