package com.example.hms.ui.home.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hms.R
import com.example.hms.screens.MainNav
import com.example.hms.screens.RootInterface
import com.example.hms.ui.components.MText16
import com.example.hms.ui.home.main.accounts.AccountTab
import com.example.hms.ui.home.main.attendance.AttendanceTab
import com.example.hms.ui.home.main.dashboard.DashboardTab
import com.example.hms.ui.home.main.maintenance.MaintenanceTab
import com.example.hms.ui.home.main.rooms.RoomTab
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import com.example.hms.ui.components.MSpacerW10
import com.example.hms.ui.components.MSpacerW20
import com.example.hms.ui.components.MTextBold30
import com.example.hms.ui.components.ShapeUtil
import com.example.hms.ui.theme.AppBG
import com.example.hms.ui.theme.IconGrey
import com.example.hms.ui.theme.LPrimaryColor
import com.example.hms.ui.theme.LSecondaryColor


@Composable
fun MainScreen(rootInterface: RootInterface ) {
    val navController = rememberNavController()

    Scaffold(topBar = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LPrimaryColor)
                .padding(horizontal = 20.dp)
                .height(100.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.profile_img),
                    contentDescription = "Profile Img",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                MSpacerW10()
                MTextBold30(textRes = R.string.imran, color = Color.White)
                MSpacerW20()
            }

            // Navigation bar takes its own space
            TopNavigationComponent(navController, modifier = Modifier.weight(1f).align(Alignment.Bottom).wrapContentHeight().height(65.dp))

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "Profile Img",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp),
                    contentScale = ContentScale.FillBounds
                )
                MSpacerW20()
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Profile Img",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )

                MSpacerW20()
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Img",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )
                MSpacerW20()
            }
        }
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TopNavHost(navController, rootInterface)
        }
    }
}


sealed class TopNavigationScreens(val route: String, val label: Int, val icon: Int) {
    data object Dashboard : TopNavigationScreens("DashboardTab-route", R.string.dashboard, R.drawable.ic_dashboard)
    data object Rooms : TopNavigationScreens("RoomsTab-route", R.string.rooms, R.drawable.ic_rooms)
    data object Attendance : TopNavigationScreens("AttendanceTab-route", R.string.attendance, R.drawable.ic_attendance)
    data object Accounts : TopNavigationScreens("AccountsTab-route", R.string.accounts, R.drawable.ic_accounts)
    data object Maintenance : TopNavigationScreens("MaintenanceTab-route", R.string.maintenance, R.drawable.ic_maintenance)

    companion object {
        val tabs = listOf(Dashboard, Rooms, Attendance, Accounts, Maintenance)
    }
}

@Composable
fun TopNavigationComponent(navController: NavHostController,modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier, containerColor = LPrimaryColor,) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        TopNavigationScreens.tabs.forEach { screen ->

            MNavigationBarItem(screen.label,screen.icon,currentRoute == screen.route){
                navController.navigate(screen.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }

            /*NavigationBarItem(
                icon = { Image(painter = painterResource(id = screen.icon), contentDescription = null) },
                label = { MText14(textRes = screen.label) },
                selected = currentRoute == screen.route,
                onClick = {

                }
            )*/
        }
    }
}


@Composable
fun MNavigationBarItem(label:Int = R.string.password,icon:Int = R.drawable.ic_dashboard,selected:Boolean = true,onClick : () -> Unit = {}){

        Row(
            modifier = Modifier
                .then(
                    if (selected) Modifier
                        .background(color = LSecondaryColor, ShapeUtil.TopBarShape())
                        .border(BorderStroke(1.dp, Color.White), shape = ShapeUtil.TopBarShape())
                        .clip(ShapeUtil.TopBarShape()) else Modifier
                )
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(4.dp).height(45.dp))
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Navigation Item Icon",
                colorFilter = ColorFilter.tint(if (selected) Color.White else IconGrey),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp)) // Space between icon and text
            MText16(
                textRes = label ,
                color = (if (selected) Color.White else IconGrey), // Text color
            )
            Spacer(modifier = Modifier.width(4.dp).height(45.dp))
        }

}

@Composable
fun TopNavHost(navController: NavHostController, rootInterface: RootInterface) {

    NavHost(navController, startDestination = TopNavigationScreens.Dashboard.route) {
        composable(TopNavigationScreens.Dashboard.route) { DashboardTab(rootInterface) }
        composable(TopNavigationScreens.Rooms.route) { RoomTab() }
        composable(TopNavigationScreens.Attendance.route) { AttendanceTab() }
        composable(TopNavigationScreens.Accounts.route) { AccountTab() }
        composable(TopNavigationScreens.Maintenance.route) { MaintenanceTab() }
        MainNav(navController,rootInterface)
    }



}