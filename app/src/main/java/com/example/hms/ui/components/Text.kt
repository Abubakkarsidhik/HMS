package com.example.hms.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.hms.ui.theme.LPrimaryColor

@Composable
fun MText16(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = Color.Unspecified){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 16.sp, color = color)
    }
}

@Composable
fun MText18(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = Color.Unspecified,fontWeight :FontWeight? = null){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 18.sp, color = color,fontWeight = fontWeight)
    }
}

@Composable
fun MText14(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = Color.Unspecified,textDecoration: TextDecoration? = null,textAlign: TextAlign = TextAlign.Start ){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 14.sp, color = color, textDecoration = textDecoration, textAlign = textAlign)
    }
}

@Composable
fun MTextBold20(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = LPrimaryColor,textDecoration: TextDecoration? = null ){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 20.sp, color = color, textDecoration = textDecoration, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MTextBold30(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = LPrimaryColor,textDecoration: TextDecoration? = null ){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 30.sp, color = color, textDecoration = textDecoration, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MTextMedium24(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = LPrimaryColor,textDecoration: TextDecoration? = null ){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 24.sp, color = color, textDecoration = textDecoration, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun MTextMedium20(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = LPrimaryColor,textDecoration: TextDecoration? = null ){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 20.sp, color = color, textDecoration = textDecoration, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun MTextMedium18(modifier: Modifier = Modifier,text:String?=null,textRes:Int?=null,color: Color = LPrimaryColor,textDecoration: TextDecoration? = null ){
    (textRes?.let { stringResource(id = it) } ?: text)?.let {
        Text(text = it,modifier = modifier, fontSize = 18.sp, color = color, textDecoration = textDecoration, fontWeight = FontWeight.Medium)
    }
}