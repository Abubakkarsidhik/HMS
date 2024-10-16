package com.example.hms.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hms.R
import com.example.hms.ui.theme.LPrimaryColor
import com.example.hms.ui.theme.LSecondaryColor


@Composable
fun MAmountCard(modifier: Modifier = Modifier,titleRes:Int?,title:String?=null,amount:String?=null,color: Color ){
    Card(modifier = modifier, shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = LSecondaryColor)) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically,) {
            Column(modifier = Modifier.weight(1f)) {
                MText16(text = title, textRes = titleRes, color = Color.White)
                MSpacerH5()
                MTextMedium24(text = "₹ $amount", color = color)
            }
            Image(painter = painterResource(id = R.drawable.ic_open), contentDescription = "open", colorFilter = ColorFilter.tint(color))
            MSpacerW5()
        }

    }
}


@Composable
fun MCard1(
    modifier: Modifier = Modifier,
    titleRes: Int? = null,
    title: String? = null,
    value: String? = null,
    color: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LSecondaryColor)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row {
                    MText16(text = title, textRes = titleRes, color = Color.White)
                    MSpacerW5()
                    Image(
                        painter = painterResource(id = R.drawable.ic_open),
                        contentDescription = "open",
                        modifier = Modifier.size(16.dp)
                    )
                }
                MSpacerH5()
                MTextMedium18(text = value, color = color)
            }
        }
    }
}

@Composable
fun MCard2(
    modifier: Modifier = Modifier,
    titleRes: Int? = null,
    title: String? = null,
    value: String? = null,
    color: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LPrimaryColor)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row {
                    MText16(text = title, textRes = titleRes, color = Color.White)
                    MSpacerW5()
                    Image(
                        painter = painterResource(id = R.drawable.ic_open),
                        contentDescription = "open",
                        modifier = Modifier.size(16.dp)
                    )
                }
                MSpacerH5()
                MTextMedium18(text = value, color = color)
            }
        }
    }
}

@Composable
fun MCardWithBtn(
    modifier: Modifier = Modifier,
    titleRes: Int? = null,
    title: String? = null,
    value: String? = null,
    color: Color,
    onClick : () -> Unit
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LPrimaryColor)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                MText16(text = title, textRes = titleRes, color = Color.White)
                MSpacerH10()
                MTextMedium24(text = value, color = color)
                MSpacerH10()
                MFilledButton(labelRes = R.string.view_list, onClick = onClick)
            }
        }
    }
}