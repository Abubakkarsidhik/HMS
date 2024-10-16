package com.example.hms.ui.auth.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.hms.R
import com.example.hms.base.BaseScreen
import com.example.hms.screens.RootInterface
import com.example.hms.screens.Screens
import com.example.hms.screens.goToScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, rootInterface: RootInterface,){
    BaseScreen {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.hms_logo), contentDescription = "hms logo")
        }
    }

    LaunchedEffect(Unit) {
        delay(1500)
        navController.goToScreen(Screens.LoginScreen)
    }
}