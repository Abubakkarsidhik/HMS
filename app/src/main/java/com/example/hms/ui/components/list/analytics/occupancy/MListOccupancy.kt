package com.example.hms.ui.components.list.analytics.occupancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hms.R
import com.example.hms.data.constant.Config
import com.example.hms.data.model.Occupancy
import com.example.hms.ui.components.MSpacerH10
import com.example.hms.ui.components.MSpacerW5
import com.example.hms.ui.components.MText18
import com.example.hms.ui.theme.LPrimaryColor
import io.jetchart.common.animation.fadeInAnimation
import io.jetchart.pie.PieChart
import io.jetchart.pie.Pies
import io.jetchart.pie.Slice
import io.jetchart.pie.renderer.FilledSliceDrawer

@Composable
fun MListOccupancy(list: List<Occupancy>){
    LazyRow {
        items(list){
            MItemOccupancy(model = it)
        }
    }
}

@Composable
private fun MItemOccupancy(model:Occupancy = Config.Hardcoded.listOccupancy[1]){
    Card(shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = LPrimaryColor), modifier = Modifier.padding(10.dp)) {
        Column(modifier = Modifier.padding(10.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                MText18(text = model.hostelName, color = White)
                MSpacerW5()
                Image(painter = painterResource(id = R.drawable.ic_open), contentDescription = "Open")
            }
            MSpacerH10()
            PieChart(pies = Pies(listOf(Slice(35f, Red), Slice(45f, Green), Slice(15f, Yellow), Slice(5f, Cyan))),
                modifier = Modifier
                    .height(210.dp)
                    .width(210.dp),
                animation = fadeInAnimation(4000),
                sliceDrawer = FilledSliceDrawer(thickness = 20f)
            )
        }
    }
}
