package com.example.laboratornaya.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.laboratornaya.dcl.sixHistoryCode
import com.example.laboratornaya.dcl.tenClass
import com.example.laboratornaya.dcl.tenClassHistory
import com.example.laboratornaya.ui.theme.amatic
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun Ten(
    navController : NavHostController,
    ten : MutableState<Boolean>
){
    val openMenuOneCurrencies = remember { mutableStateOf(false) }
    val openMenuTwoCurrencies = remember { mutableStateOf(false) }
    val countryOne = remember { mutableStateOf("") }
    val countryTwo = remember { mutableStateOf("") }
    val countryOneName = remember { mutableStateOf("") }
    val countryTwoName = remember { mutableStateOf("") }
    val how = remember { mutableStateOf("") }
    val rezult = remember { mutableStateOf("") }
    val context = LocalContext.current
    
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = two
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "обмен валюты",
                color = one,
                fontSize = 54.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 50.dp)
                    .clickable {
                        navController.navigateUp()
                    },
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Button(
                        onClick = {
                            openMenuOneCurrencies.value = true
                        },
                        modifier = Modifier
                            .size(width = 270.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(one)
                    ) {
                        Text(
                            text = if (countryOne.value.isNotEmpty()){
                                countryOneName.value
                            }
                            else{
                                "выбрать валюту"
                            },
                            color = two,
                            fontSize = 32.sp,
                            fontFamily = amatic
                        )
                    }
                    if (openMenuOneCurrencies.value){
                        DropdownMenu(
                            modifier = Modifier
                                .background(one),
                            expanded = openMenuOneCurrencies.value,
                            onDismissRequest = { openMenuOneCurrencies.value = false }
                        ) {
                            for (i in tenClass.ordersAll.indices){
                                DropdownMenuItem(
                                    text = { Text(
                                        text = tenClass.ordersAll.get(index = i).currency.toString(),
                                        fontFamily = amatic,
                                        color = two,
                                        fontSize = 25.sp
                                    ) },
                                    onClick = {
                                        countryOneName.value = tenClass.ordersAll.get(index = i).currency.toString()
                                        countryOne.value = tenClass.ordersAll.get(index = i).exchangeRate.toString()
                                        openMenuOneCurrencies.value = false
                                    }
                                )
                            }
                        }
                    }
                }
                Text(
                    "в",
                    color = one,
                    fontSize = 28.sp,
                    fontFamily = amatic,
                    modifier = Modifier
                )

                Box {
                    Button(
                        onClick = {
                            openMenuTwoCurrencies.value = true
                        },
                        modifier = Modifier
                            .size(width = 270.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(one)
                    ) {
                        Text(
                            text = if (countryTwo.value.isNotEmpty()){
                                countryTwoName.value
                            }
                            else{
                                "выбрать валюту"
                            },
                            color = two,
                            fontSize = 32.sp,
                            fontFamily = amatic
                        )
                    }
                    if (openMenuTwoCurrencies.value){
                        DropdownMenu(
                            modifier = Modifier
                                .background(one),
                            expanded = openMenuTwoCurrencies.value,
                            onDismissRequest = { openMenuTwoCurrencies.value = false }
                        ) {
                            for (i in tenClass.ordersAll.indices){
                                DropdownMenuItem(
                                    text = { Text(
                                        text = tenClass.ordersAll.get(index = i).currency.toString(),
                                        fontFamily = amatic,
                                        color = two,
                                        fontSize = 25.sp
                                    ) },
                                    onClick = {
                                        countryTwoName.value = tenClass.ordersAll.get(index = i).currency.toString()
                                        countryTwo.value = tenClass.ordersAll.get(index = i).exchangeRate.toString()
                                        openMenuTwoCurrencies.value = false
                                    }
                                )
                            }
                        }
                    }
                }

                OutlinedTextField(
                    value = how.value,
                    onValueChange = {
                            new -> how.value = new
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
                            text = "сколько",
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
            }

            Button(
                onClick = {
                    if (countryOne.value.isNotEmpty() && countryTwo.value.isNotEmpty() && how.value.isNotEmpty()){
                        rezult.value = ((countryOne.value.toFloat() / countryTwo.value.toFloat()) * how.value.toFloat()).toString()
                    }
                    else{
                        Toast.makeText(context, "не выбрано", Toast.LENGTH_SHORT).show()
                    }
                    if (rezult.value.isNotEmpty()){
                        tenClassHistory.Companion.ordersAll.add(tenClassHistory(tenClassHistory.ordersAll.lastIndex+1, rezult.value, countryTwoName.value))
                    }
                },
                modifier = Modifier
                    .padding(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(one)
            ) {
                Text(
                    text = "конвертировать",
                    color = two,
                    fontSize = 32.sp,
                    fontFamily = amatic
                )
            }

            Text(
                text = rezult.value,
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
                    navController.navigate("tenhistory")
                },
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .align(Alignment.End)
                    .padding(horizontal = 20.dp)

            ) {
                Text(
                    text = "история >",
                    color = one,
                    fontSize = 28.sp,
                    fontFamily = amatic
                )
            }
        }
    }
}