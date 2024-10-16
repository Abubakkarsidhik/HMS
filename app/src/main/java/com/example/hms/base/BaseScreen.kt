package com.example.hms.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BaseScreen(content : @Composable () -> Unit){
    Box(modifier = Modifier.fillMaxSize()){
        content()
    }
}