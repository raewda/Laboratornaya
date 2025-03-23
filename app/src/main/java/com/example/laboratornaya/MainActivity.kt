package com.example.laboratornaya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratornaya.screens.StartAction
import com.example.laboratornaya.screens.Four
import com.example.laboratornaya.screens.FourHistory
import com.example.laboratornaya.screens.Six
import com.example.laboratornaya.screens.SixHistory
import com.example.laboratornaya.screens.Ten
import com.example.laboratornaya.screens.TenHistory
import com.example.laboratornaya.ui.theme.LaboratornayaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaboratornayaTheme {

                val navController = rememberNavController()
                val start = remember { mutableStateOf(false) }
                val four = remember { mutableStateOf(false) }
                val fourhistory = remember { mutableStateOf(false) }
                val six = remember { mutableStateOf(false) }
                val sixhistory = remember { mutableStateOf(false) }
                val ten = remember { mutableStateOf(false) }
                val tenhistory = remember { mutableStateOf(false) }

                NavHost(
                    navController = navController,
                    startDestination = "start"
                ){
                    composable("start") {
                        StartAction(
                            navController,
                            start = start
                        )
                    }
                    composable("four") {
                        Four(
                            navController,
                            four = four
                        )
                    }
                    composable("fourhistory") {
                        FourHistory(
                            navController,
                            fourhistory = fourhistory
                        )
                    }
                    composable("six") {
                        Six(
                            navController,
                            six = six
                        )
                    }
                    composable("sixhistory") {
                        SixHistory(
                            navController,
                            sixhistory = sixhistory
                        )
                    }
                    composable("ten") {
                        Ten(
                            navController,
                            ten = ten
                        )
                    }
                    composable("tenhistory") {
                        TenHistory(
                            navController,
                            tenhistory = tenhistory
                        )
                    }
                }
            }
        }
    }
}
