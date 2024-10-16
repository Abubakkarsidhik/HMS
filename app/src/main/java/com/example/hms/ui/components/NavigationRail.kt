package com.example.hms.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hms.R
import com.example.hms.ui.theme.IconGrey
import com.example.hms.ui.theme.LSecondaryColor

@Preview(showBackground = true, showSystemUi = true, device = Devices.TABLET)
@Composable
fun MNavigationRailItem(label:Int = R.string.password, icon:Int = R.drawable.ic_dashboard, selected:Boolean = true, onClick : () -> Unit = {}){
    Row(
        modifier = Modifier
            .then(if (selected) Modifier.background(color = LSecondaryColor, shape = RoundedCornerShape(8.dp)) else Modifier)
            .fillMaxWidth()
            .padding(17.dp)
            .clip(
                RoundedCornerShape(8.dp)
            ).clickable { onClick() }, verticalAlignment = Alignment.CenterVertically
    ) {
        MSpacerW10()
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Rail Icon",
            colorFilter = ColorFilter.tint(if (selected) Color.White else IconGrey)
        )
        MSpacerW10()
        MText18(
            textRes = label,
            color = if (selected) Color.White else IconGrey,
            fontWeight = if (selected) FontWeight.Bold else null
        )
        MSpacerW10()

    }
}