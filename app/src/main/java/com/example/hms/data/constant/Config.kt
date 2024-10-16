package com.example.hms.data.constant

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.hms.data.model.Hostelers
import com.example.hms.data.model.Occupancy

object Config {

    @Composable
    fun isTablet(): Boolean {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp >= 600
    }


    object Hardcoded {
        val listOccupancy = listOf<Occupancy>(Occupancy("City 1", "100"),Occupancy("City 2","95"))
        val listHostelers = listOf<Hostelers>(Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"),Hostelers("Sidhik","9551147833"))
    }
}