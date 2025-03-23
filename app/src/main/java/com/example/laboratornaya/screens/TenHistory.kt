package com.example.laboratornaya.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.laboratornaya.dcl.tenClass
import com.example.laboratornaya.dcl.tenClassHistory
import com.example.laboratornaya.ui.theme.amatic
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun TenHistory(
    navController : NavHostController,
    tenhistory : MutableState<Boolean>
){
    val openDialog = remember { mutableStateOf(false) }
    val currencyName = remember { mutableStateOf("") }
    val exchangeRateDigits = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "выполненные операции",
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

            LazyRow{ items(tenClass.ordersAll){ item ->
                if (item != null && item.id != 0){
                    tenClassColumn(item)
                }
            }
            }

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

            LazyColumn { items(tenClassHistory.ordersAll){ item ->
                if (item != null && item.id != 0){
                    tenClassHistoryColumn(item)
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
                        modifier = Modifier,
                        colors = CardDefaults.cardColors(two)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                "валюта",
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                color = one,
                                fontFamily = amatic,
                                fontSize = 25.sp,
                                softWrap = true
                            )

                            OutlinedTextField(
                                value = currencyName.value,
                                onValueChange = {
                                        new -> currencyName.value = new
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
                                        text = "ввести название валюты",
                                        color = two,
                                        fontSize = 24.sp
                                    ) },
                                shape = RoundedCornerShape(12.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = one,
                                    unfocusedIndicatorColor = one
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )

                            Text(
                                "курс",
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .padding(horizontal = 15.dp),
                                color = one,
                                fontFamily = amatic,
                                fontSize = 25.sp,
                                softWrap = true
                            )

                            OutlinedTextField(
                                value = exchangeRateDigits.value,
                                onValueChange = {
                                        new -> exchangeRateDigits.value = new
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
                                        text = "ввести курс",
                                        color = two,
                                        fontSize = 24.sp
                                    ) },
                                shape = RoundedCornerShape(12.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = one,
                                    unfocusedIndicatorColor = one
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )

                            Button(
                                onClick = {
                                    tenClass.Companion.ordersAll.add(tenClass(tenClass.ordersAll.lastIndex+1, currencyName.value, exchangeRateDigits.value.toFloat()))
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
fun tenClassHistoryColumn(
    item : tenClassHistory
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp)
            .height(50.dp),
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
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = item.summ,
                        fontSize = 26.sp,
                        color = one,
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = item.currency,
                        fontSize = 26.sp,
                        color = one,
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
fun tenClassColumn(
    item: tenClass
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp)
            .height(50.dp),
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
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = item.currency,
                        fontSize = 26.sp,
                        color = one,
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "  ",
                        fontSize = 26.sp,
                        color = one,
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = item.exchangeRate.toString(),
                        fontSize = 26.sp,
                        color = one,
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}