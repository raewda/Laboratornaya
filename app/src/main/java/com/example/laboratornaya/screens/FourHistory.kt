package com.example.laboratornaya.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun FourHistory(
    navController : NavHostController,
    fourhistory : MutableState<Boolean>
){
    val openDialog = remember { mutableStateOf(false) }
    val question = remember { mutableStateOf("") }
    val hint = remember { mutableStateOf("") }
    val answer = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "все загадки",
                color = two,
                fontSize = 54.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 20.dp)
                    .clickable {
                        navController.navigateUp()
                    },
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )

            TextButton(
                onClick = {
                    openDialog.value = true
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    "добавить",
                    color = two,
                    fontSize = 26.sp,
                    fontFamily = amatic
                )
            }

            LazyColumn { items(fourClass.ordersAll){ item ->
                if (item != null){
                    fourClassColumn(item)
                }
                }
            }

            if (openDialog.value){
                Dialog(
                    onDismissRequest = {
                        openDialog.value = false
                    }
                ){
                    Card(
                        modifier = Modifier
                            .size(width = 300.dp, height = 450.dp),
                        colors = CardDefaults.cardColors(two)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                "загадка",
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                color = one,
                                fontFamily = amatic,
                                fontSize = 25.sp,
                                softWrap = true
                            )

                            OutlinedTextField(
                                value = question.value,
                                onValueChange = {
                                        new -> question.value = new
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.7F),
                                enabled = true,
                                readOnly = false,
                                singleLine = false,
                                textStyle = TextStyle(
                                    fontSize = 24.sp,
                                    color = one,
                                    fontFamily = amatic
                                ),
                                placeholder = {
                                    Text(
                                        text = "ввести загадку",
                                        color = two,
                                        fontSize = 24.sp
                                    ) },
                                shape = RoundedCornerShape(12.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = one,
                                    unfocusedIndicatorColor = one
                                )
                            )

                            Text(
                                "подсказка",
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                color = one,
                                fontFamily = amatic,
                                fontSize = 25.sp,
                                softWrap = true
                            )

                            OutlinedTextField(
                                value = hint.value,
                                onValueChange = {
                                        new -> hint.value = new
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.7F),
                                enabled = true,
                                readOnly = false,
                                singleLine = false,
                                textStyle = TextStyle(
                                    fontSize = 24.sp,
                                    color = one,
                                    fontFamily = amatic
                                ),
                                placeholder = {
                                    Text(
                                        text = "ввести подсказку",
                                        color = two,
                                        fontSize = 24.sp
                                    ) },
                                shape = RoundedCornerShape(12.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = one,
                                    unfocusedIndicatorColor = one
                                )
                            )

                            Text(
                                "ответ",
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                color = one,
                                fontFamily = amatic,
                                fontSize = 25.sp,
                                softWrap = true
                            )

                            OutlinedTextField(
                                value = answer.value,
                                onValueChange = {
                                        new -> answer.value = new
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.7F),
                                enabled = true,
                                readOnly = false,
                                singleLine = false,
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

                            Button(
                                onClick = {
                                    fourClass.Companion.ordersAll.add(fourClass(fourClass.ordersAll.lastIndex+1, question.value, answer.value, hint.value))
                                    openDialog.value = false
                                },
                                modifier = Modifier
                                    .padding(vertical = 15.dp),
                                colors = ButtonDefaults.buttonColors(one)
                            ) {
                                Text(
                                    text = "добавить",
                                    color = two,
                                    fontSize = 22.sp,
                                    fontFamily = amatic
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun fourClassColumn(
    item : fourClass
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp)
            .height(200.dp),
        colors = CardDefaults.cardColors(two)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 5.dp)
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(50F, true)
            ) {
                Text(
                    text = item.question,
                    fontSize = 20.sp,
                    color = one,
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(25F, true)
            ) {
                Text(
                    text = item.hint,
                    fontSize = 20.sp,
                    color = one,
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(25F, true)
            ) {
                Text(
                    text = item.answer,
                    fontSize = 20.sp,
                    color = one,
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}