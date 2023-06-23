package com.example.cryptoapp.presentation.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cryptoapp.utils.Screen
import com.example.mycomposeskeleton.R


@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel
) {

    LaunchedEffect(true ) {
        viewModel.goToScreen.collect {
            navController.navigate(it.route) {
                popUpTo(Screen.Splash.route) {
                    inclusive = true
                }
            }
        }
    }

    viewModel.initSplash()
    SplashContent()

}

@Composable
fun SplashContent() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "CryptoApp",
            color = MaterialTheme.colors.primary,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
    }

}