package com.example.hms.ui.home.main.dashboard.analytics

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hms.R
import com.example.hms.base.BaseScreen
import com.example.hms.data.constant.Config
import com.example.hms.screens.RootInterface
import com.example.hms.ui.components.MAmountCard
import com.example.hms.ui.components.MCard1
import com.example.hms.ui.components.MSpacerH10
import com.example.hms.ui.components.MSpacerH5
import com.example.hms.ui.components.MSpacerW10
import com.example.hms.ui.components.MSpacerW20
import com.example.hms.ui.components.MTextBold20
import com.example.hms.ui.components.ShapeUtil
import com.example.hms.ui.components.bars.StackedBar
import com.example.hms.ui.components.list.analytics.hostelers.MListHostelers
import com.example.hms.ui.components.list.analytics.occupancy.MListOccupancy
import com.example.hms.ui.theme.LPrimaryColor
import com.example.hms.ui.theme.LSecondaryColor
import io.jetchart.common.animation.fadeInAnimation
import io.jetchart.pie.PieChart
import io.jetchart.pie.Pies
import io.jetchart.pie.Slice
import io.jetchart.pie.renderer.FilledSliceDrawer

@Composable
fun AnalyticsRail(navHostController: NavHostController,rootInterface: RootInterface){

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
                    MTextBold20(textRes = R.string.occupancy, color = White)
                    MListOccupancy(list = Config.Hardcoded.listOccupancy)
                }
                MSpacerH10()
                Column(
                    Modifier
                        .background(color = LPrimaryColor, shape = ShapeUtil.appShape)
                        .padding(15.dp)) {
                    MTextBold20(text = "Fees Collection", color = White)
                    MSpacerH5()
                    Row {
                        PieChart(pies = Pies(listOf(Slice(35f, Red), Slice(45f, Green), Slice(15f, Yellow), Slice(5f, Cyan))),
                            modifier = Modifier
                                .height(170.dp)
                                .width(170.dp),
                            animation = fadeInAnimation(4000),
                            sliceDrawer = FilledSliceDrawer(thickness = 20f)
                        )

                        MSpacerW20()
                        Column {
                            Row {
                                MAmountCard(modifier = Modifier.weight(1f), titleRes = R.string.excepted, amount = "52,00,000", color = White)
                                MSpacerW10()
                                MAmountCard(modifier = Modifier.weight(1f), titleRes = R.string.remaining, amount = "15,60,000", color = Yellow)
                            }
                            MSpacerH10()
                            Row {
                                MAmountCard(modifier = Modifier.weight(1f), titleRes = R.string.collected, amount = "26,00,000", color = Cyan)
                                MSpacerW10()
                                MAmountCard(modifier = Modifier.weight(1f), titleRes = R.string.overdue, amount = "10,40,000", color = Magenta)
                            }
                        }
                    }
                }
                MSpacerH10()
                Column(
                    Modifier
                        .background(color = LPrimaryColor, shape = ShapeUtil.appShape)
                        .padding(15.dp)) {
                    MTextBold20(textRes = R.string.complaints, color = White)
                    MSpacerH10()
                    Row {
                        MSpacerW10()
                        StackedBar(modifier = Modifier
                            .height(72.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .weight(1f))
                        MSpacerW10()
                        MCard1(titleRes = R.string.total_complaints, value = "158", color = White, modifier = Modifier.weight(1f))
                        MSpacerW10()
                        MCard1(titleRes = R.string.resolved, value = "96", color = Cyan, modifier = Modifier.weight(1f))
                        MSpacerW10()
                        MCard1(titleRes = R.string.open, value = "62", color = Yellow, modifier = Modifier.weight(1f))

                    }
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