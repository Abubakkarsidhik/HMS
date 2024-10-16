package com.example.hms.ui.components.list.hostelers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.hms.data.model.Hostelers

@Composable
fun MListHostelers(list: List<Hostelers>){
    LazyColumn {
        items(list){

        }
    }
}

@Composable
private fun MItemHostelers(model:Hostelers){


}