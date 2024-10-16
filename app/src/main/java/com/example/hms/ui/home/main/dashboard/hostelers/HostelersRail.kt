package com.example.hms.ui.home.main.dashboard.hostelers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hms.R
import com.example.hms.base.BaseScreen
import com.example.hms.data.constant.Config
import com.example.hms.screens.RootInterface
import com.example.hms.ui.components.MAmountCard
import com.example.hms.ui.components.MCard1
import com.example.hms.ui.components.MCard2
import com.example.hms.ui.components.MCardWithBtn
import com.example.hms.ui.components.MSearchTextField
import com.example.hms.ui.components.MSpacerH10
import com.example.hms.ui.components.MSpacerH5
import com.example.hms.ui.components.MSpacerW10
import com.example.hms.ui.components.MSpacerW20
import com.example.hms.ui.components.MSpacerW5
import com.example.hms.ui.components.MText16
import com.example.hms.ui.components.MTextBold20
import com.example.hms.ui.components.ShapeUtil
import com.example.hms.ui.components.bars.StackedBar
import com.example.hms.ui.components.list.analytics.hostelers.MListHostelers
import com.example.hms.ui.components.list.analytics.occupancy.MListOccupancy
import com.example.hms.ui.theme.LPrimaryColor
import com.example.hms.ui.theme.LSecondaryColor
import com.example.hms.ui.theme.LightGrey
import io.jetchart.common.animation.fadeInAnimation
import io.jetchart.pie.PieChart
import io.jetchart.pie.Pies
import io.jetchart.pie.Slice
import io.jetchart.pie.renderer.FilledSliceDrawer

@Composable
fun HostelersRail(navHostController: NavHostController,rootInterface: RootInterface){
    BaseScreen {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier
                .fillMaxWidth(0.70f)
                .padding(start = 20.dp)) {
                Column(
                    Modifier
                        .background(color = LSecondaryColor, shape = ShapeUtil.appShape)
                        .fillMaxWidth()
                        .padding(15.dp)) {
                    Row {
                        Row {
                            MCard2(modifier = Modifier.weight(1f), titleRes = R.string.total_hostelers, value = "3542", color = White)
                            MSpacerW10()
                            MCard2(modifier = Modifier.weight(1f), titleRes = R.string.in_hostel, value = "1543", color = Cyan)
                            MSpacerW10()
                            MCard2(modifier = Modifier.weight(1f), titleRes = R.string.outside_hostel, value = "2500", color = LightGrey)
                            MSpacerW10()
                        }
                        MSpacerH10()
                        Row {
                            MCard2(modifier = Modifier.weight(1f), titleRes = R.string.hostelers_assigned, value = "2569", color = Magenta)
                            MSpacerW10()
                            MCard2(modifier = Modifier.weight(1f), titleRes = R.string.hostelers_removed, value = "1000", color = Cyan)
                            MSpacerW10()
                            Box(modifier = Modifier.weight(1f))
                            MSpacerW10()
                        }

                        MCardWithBtn(titleRes = R.string.fees_defaulters, value = "150", color = Yellow){

                        }

                    }



                }
                MSpacerH10()

                Column(
                    Modifier
                        .background(color = LSecondaryColor, shape = ShapeUtil.appShape)
                        .padding(15.dp)) {
                    MTextBold20(textRes = R.string.hostelers, color = White)
                    MSpacerH10()
                    Row {
                        MSearchTextField(modifier = Modifier.weight(0.80f),hintRes = R.string.hint_search){

                        }
                        MSpacerW5()
                        Row(modifier = Modifier
                            .background(color = LPrimaryColor, shape = RoundedCornerShape(8.dp))
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 10.dp, vertical = 5.dp)) {
                            Image(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "filter")
                            MText16(textRes = R.string.filter)
                        }
                    }
                    MSpacerH10()

                }



            }
            MSpacerW10()
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = LPrimaryColor, shape = RoundedCornerShape(8.dp))
                .padding(10.dp)) {
                Column(modifier = Modifier.fillMaxSize()) {
                    MSpacerH10()
                    MTextBold20(textRes = R.string.hostlers_update, color = White)
                    MSpacerH10()
                    MListHostelers(Config.Hardcoded.listHostelers)

                }


            }
        }

    }


}