package com.example.hms

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.hms.screens.Navigation

@Composable
fun App(){
    val navHost = rememberNavController()
    Navigation(navHost)
}