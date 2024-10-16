package com.example.hms.ui.home.main.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hms.R
import com.example.hms.base.BaseScreen
import com.example.hms.screens.MainNav
import com.example.hms.screens.RootInterface
import com.example.hms.screens.Screens
import com.example.hms.screens.goToScreen
import com.example.hms.ui.components.MNavigationRailItem
import com.example.hms.ui.home.main.dashboard.analytics.AnalyticsRail
import com.example.hms.ui.home.main.dashboard.hostelers.HostelersRail
import com.example.hms.ui.theme.AppBG
import com.example.hms.ui.theme.LPrimaryColor

sealed class DashboardNavigationRail(val route: String, val label: Int, val icon: Int) {
    data object Analytics :
        DashboardNavigationRail("AnalyticsRail-route", R.string.analytics, R.drawable.ic_analytics)

    data object Hostelers :
        DashboardNavigationRail("HostelersRail-route", R.string.hostelers, R.drawable.ic_hostelers)

    companion object {
        val rails = listOf(Analytics, Hostelers)
    }
}

@Composable
fun DashboardTab(rootInterface: RootInterface) {
    val navController = rememberNavController()
    BaseScreen {
        Scaffold(containerColor = AppBG) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                // Navigation Rail on the left side
                NavigationRailComponent(navController = navController)

                // Content area based on the navigation route
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(it)
                ) {
                    DashboardNavHost(navController, rootInterface = rootInterface)
                }
            }
        }
    }

}

@Composable
fun DashboardNavHost(navController: NavHostController, rootInterface: RootInterface) {

    NavHost(navController, startDestination = DashboardNavigationRail.Hostelers.route) {
        composable(DashboardNavigationRail.Analytics.route) {
            AnalyticsRail(
                navController,
                rootInterface
            )
        }
        composable(DashboardNavigationRail.Hostelers.route) {
            HostelersRail(
                navController,
                rootInterface
            )
        }

        MainNav(navController, rootInterface)
    }

}



@Preview(showBackground = true, showSystemUi = true, device = Devices.TABLET)
@Composable
fun DashboardPreview() {
    val navController = rememberNavController()
    val rootNavInt = object : RootInterface {
        override fun logout(message: String?) {
            navController.goToScreen(Screens.LoginScreen, message)
        }
    }
    BaseScreen {
        Scaffold(containerColor = AppBG) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                // Navigation Rail on the left side
                NavigationRailComponent(navController = navController)

                // Content area based on the navigation route
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(it)
                ) {
                    DashboardNavHost(navController, rootInterface = rootNavInt)
                }
            }
        }
    }
}

@Composable
fun NavigationRailComponent(navController: NavHostController) {
    NavigationRail(
        containerColor = LPrimaryColor,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(0.20f)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        DashboardNavigationRail.rails.forEach { rails ->

            MNavigationRailItem(
                label = rails.label, icon = rails.icon,
                selected = currentRoute == rails.route
            ) {
                navController.navigate(rails.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }

        }
    }
}



