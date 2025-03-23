package com.example.laboratornaya.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
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
import com.example.laboratornaya.ui.theme.one
import com.example.laboratornaya.ui.theme.two

@Composable
fun Six(
    navController : NavHostController,
    six : MutableState<Boolean>
){
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
                    .padding(vertical = 50.dp),
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )


        }
    }
}