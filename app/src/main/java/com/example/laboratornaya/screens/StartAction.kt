package com.example.laboratornaya.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.laboratornaya.ui.theme.amatic
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun StartAction(
    navController : NavHostController,
    start : MutableState<Boolean>
){
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
                "Laboratornaya project for you :)",
                color = one,
                fontSize = 44.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 50.dp),
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate("four")
                    },
                    modifier = Modifier
                        .size(width = 270.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(one)
                ) {
                    Text(
                        "four",
                        color = two,
                        fontSize = 32.sp,
                        fontFamily = amatic
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("six")
                    },
                    modifier = Modifier
                        .size(width = 270.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(one)
                ) {
                    Text(
                        "six",
                        color = two,
                        fontSize = 32.sp,
                        fontFamily = amatic
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("ten")
                    },
                    modifier = Modifier
                        .size(width = 270.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(one)
                ) {
                    Text(
                        "ten",
                        color = two,
                        fontSize = 32.sp,
                        fontFamily = amatic
                    )
                }
            }
            Text(
                "raewda & glindaqu productions",
                color = one,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .padding(vertical = 50.dp),
                textAlign = TextAlign.Center
            )
        }

    }
}

