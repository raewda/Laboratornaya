package com.example.laboratornaya.screens

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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

    val hint = remember { mutableStateOf("") }

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
                    .padding(vertical = 50.dp),
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )

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
                        colors = CardDefaults.cardColors(one)
                    ) {
                        Column(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                        ) {
                            Text(
                                text = hint.value,
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

@Composable
fun fourClassColumn(
    item : fourClass
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(two)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 5.dp)
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(60F, true)
            ) {
                Text(
                    text = item.question,
                    fontSize = 20.sp,
                    color = one,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(40F, true)
            ) {
                Text(
                    text = item.answer,
                    fontSize = 20.sp,
                    color = one,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}