package com.example.hms.ui.components.list.analytics.hostelers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hms.R
import com.example.hms.data.model.Hostelers
import com.example.hms.ui.components.MSpacerH10
import com.example.hms.ui.components.MSpacerW10
import com.example.hms.ui.components.MText14
import com.example.hms.ui.components.MText16
import com.example.hms.ui.theme.LSecondaryColor

@Composable
fun MListHostelers(list: List<Hostelers>){
    LazyColumn {
        items(list){
            ItemHostelers(it)
        }
    }
}


@Composable
private fun ItemHostelers(model:Hostelers ){
    Column(modifier = Modifier
        .padding(bottom = 10.dp)
        .fillMaxWidth()
        .background(color = LSecondaryColor, shape = RoundedCornerShape(8.dp))
        .padding(10.dp)) {
        Row() {
            Image(painter = painterResource(id = R.drawable.profile_img), contentDescription = "hostlers img", modifier = Modifier
                .size(40.dp)
                .clip(
                    CircleShape
                ))
            MSpacerW10()
            Column {
                MText16(text = model.name, color = Color.White)
                MText14(text = model.mobileNo, color = Color.White)
            }

        }
        MSpacerH10()
    }

}