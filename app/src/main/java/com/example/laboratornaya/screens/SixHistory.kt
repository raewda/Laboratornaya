package com.example.laboratornaya.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.laboratornaya.dcl.sixHistoryCode
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun SixHistory(
    navController : NavHostController,
    sixhistory : MutableState<Boolean>
){
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
                "все штрих-коды",
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

            LazyColumn { items(sixHistoryCode.ordersAll){ item ->
                if (item != null && item.id != 0){
                    sixHistoryCodeColumn(item)
                }
            }
            }
        }
    }
}

@Composable
fun sixHistoryCodeColumn(
    item : sixHistoryCode
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
                Text(
                    text = item.code,
                    fontSize = 26.sp,
                    color = one,
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}