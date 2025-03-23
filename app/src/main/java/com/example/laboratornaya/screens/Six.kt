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
import com.example.laboratornaya.dcl.fourClass
import com.example.laboratornaya.dcl.sixClass
import com.example.laboratornaya.dcl.sixHistoryCode
import com.example.laboratornaya.dcl.sixProductClass
import com.example.laboratornaya.ui.theme.amatic
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun Six(
    navController : NavHostController,
    six : MutableState<Boolean>
){

    val weight = remember { mutableStateOf("") }
    val openMenuProduct = remember { mutableStateOf(false) }
    val openMenuCountry = remember { mutableStateOf(false) }
    val product = remember { mutableStateOf("") }
    val country = remember { mutableStateOf("") }
    val rezult = remember { mutableStateOf("") }
    val context = LocalContext.current

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
        ) {
            Text(
                "штрих-код",
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
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box {
                    Button(
                        onClick = {
                            openMenuProduct.value = true
                        },
                        modifier = Modifier
                            .size(width = 270.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(one)
                    ) {
                        Text(
                            text = "добавить продукт",
                            color = two,
                            fontSize = 32.sp,
                            fontFamily = amatic
                        )
                    }
                    if (openMenuProduct.value){
                        DropdownMenu(
                            modifier = Modifier
                                .background(one),
                            expanded = openMenuProduct.value,
                            onDismissRequest = { openMenuProduct.value = false }
                        ) {
                            for (i in sixProductClass.ordersAll.indices){
                                DropdownMenuItem(
                                    text = { Text(
                                        text = sixProductClass.ordersAll.get(index = i).product.toString(),
                                        fontFamily = amatic,
                                        color = two,
                                        fontSize = 25.sp
                                    ) },
                                    onClick = {
                                        product.value = sixProductClass.ordersAll.get(index = i).code.toString()
                                        openMenuProduct.value = false
                                    }
                                )
                            }
                        }
                    }
                }

                Text(
                    "ввести вес, в гр",
                    color = one,
                    fontSize = 22.sp,
                    fontFamily = amatic
                )

                OutlinedTextField(
                    value = weight.value,
                    onValueChange = {
                            new -> weight.value = new
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
                            text = "ввести вес",
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

                Box {
                    Button(
                        onClick = {
                            openMenuCountry.value = true
                        },
                        modifier = Modifier
                            .size(width = 270.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(one)
                    ) {
                        Text(
                            text = "добавить код страны",
                            color = two,
                            fontSize = 32.sp,
                            fontFamily = amatic
                        )
                    }
                    if (openMenuCountry.value){
                        DropdownMenu(
                            modifier = Modifier
                                .background(one),
                            expanded = openMenuCountry.value,
                            onDismissRequest = { openMenuCountry.value = false }
                        ) {
                            for (i in sixClass.ordersAll.indices){
                                DropdownMenuItem(
                                    text = { Text(
                                        text = sixClass.ordersAll.get(index = i).country.toString(),
                                        fontFamily = amatic,
                                        color = two,
                                        fontSize = 25.sp
                                    ) },
                                    onClick = {
                                        country.value = sixClass.ordersAll.get(index = i).code.toString()
                                        openMenuCountry.value = false
                                    }
                                )
                            }
                        }
                    }
                }
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

            Button(
                onClick = {
                    if(country.value.isNotEmpty() && product.value.isNotEmpty() && weight.value.isNotEmpty()){
                        rezult.value = country.value + " " + product.value + " " + weight.value
                    }
                    else{
                        Toast.makeText(context, "не выбрано", Toast.LENGTH_SHORT).show()
                    }
                    if (rezult.value.isNotEmpty()){
                        sixHistoryCode.Companion.ordersAll.add(sixHistoryCode(sixHistoryCode.ordersAll.lastIndex+1, rezult.value))
                    }
                },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(one)
            ) {
                Text(
                    text = "сформировать штрих-код",
                    color = two,
                    fontSize = 32.sp,
                    fontFamily = amatic
                )
            }

            TextButton(
                onClick = {
                    navController.navigate("sixhistory")
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

