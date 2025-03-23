package com.example.laboratornaya.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.laboratornaya.dcl.fourClass
import com.example.laboratornaya.ui.theme.amatic
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun Four(
    navController : NavHostController,
    four : MutableState<Boolean>
){
    val item = remember { mutableStateOf(fourClass.one) }
    val answer = remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }
    var count = 0

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = two
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                "загадка",
                color = one,
                fontSize = 54.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 50.dp),
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    item.value = fourClass.ordersAll.random()
                },
                modifier = Modifier
                    .size(width = 270.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(one)
            ) {
                Text(
                    text = "загадать загадку",
                    color = two,
                    fontSize = 32.sp,
                    fontFamily = amatic
                )
            }

            Text(
                text = item.value.question,
                color = one,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 20.dp),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 20.dp)
            ) {
                OutlinedTextField(
                    value = answer.value,
                    onValueChange = {
                            new -> answer.value = new
                    },
                    modifier = Modifier,
                    enabled = true,
                    readOnly = false,
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 24.sp,
                        color = one,
                        fontFamily = amatic
                    ),
                    placeholder = {
                        Text(
                            text = "ввести ответ",
                            color = two,
                            fontSize = 24.sp
                        ) },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = one,
                        unfocusedIndicatorColor = one
                    )
                )

                TextButton(
                    onClick = {
                        openDialog.value = true
                        count++
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Text(
                        "подсказка",
                        color = one,
                        fontSize = 22.sp,
                        fontFamily = amatic
                    )
                }
            }

            Text(
                text =
                    if(answer.value.isNotEmpty()){
                        if (answer.value == item.value.answer){
                            "верно"
                        }
                        else{
                            "неверно"
                        }
                    }
                    else if(count >= 3){
                        item.value.answer
                    }
                else{
                    ""
                },
                color = one,
                fontSize = 40.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 50.dp),
                textAlign = TextAlign.Center,
                lineHeight = 50.sp
            )

            TextButton(
                onClick = {
                    navController.navigate("fourhistory")
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 20.dp)

            ) {
                Text(
                    text = "другие загадки >",
                    color = one,
                    fontSize = 22.sp,
                    fontFamily = amatic
                )
            }

            if (openDialog.value){
                Dialog(
                    onDismissRequest = {
                        openDialog.value = false
                    }
                ){
                    Card(
                        modifier = Modifier,
                        colors = CardDefaults.cardColors(one)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = item.value.hint,
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                color = two,
                                fontFamily = amatic,
                                fontSize = 25.sp,
                                softWrap = true
                            )
                        }
                    }
                }
            }
        }
    }
}

