package com.example.hms.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hms.R
import com.example.hms.ui.theme.LPrimaryColor
import com.example.hms.ui.theme.LightGrey
import com.example.hms.ui.theme.TFGrey


@Composable
fun MTextField(title:String?=null,titleRes:Int?=null,hint:String?=null,hintRes:Int?=null,painter:Int,onValueChange : (String) -> Unit){
    var textField by remember {
        mutableStateOf<String>("")
    }
    Column {
        MText16(text = title, textRes = titleRes)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = TFGrey)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)){
                    BasicTextField(value = textField, onValueChange = {
                        textField = it
                        onValueChange(it)
                    })
                    if (textField.isBlank()){
                        MText14(text = hint, textRes = hintRes, color = LightGrey)
                    }
                }
                Image(painter = painterResource(id = painter), contentDescription = "TextField Icon")
            }
        }
    }
}

@Composable
fun MPhoneTextField(title:String?=null,titleRes:Int?=null,hint:String?=null,hintRes:Int?=null,painter:Int,onValueChange : (String) -> Unit){
    var textField by remember {
        mutableStateOf<String>("")
    }
    Column {
        MText16(text = title, textRes = titleRes)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = TFGrey)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)) {
                    if (textField.isNotEmpty() && textField.first().isDigit()) {
                        MText14(textRes = R.string.mobile_no_code)
                    }
                    Box(){
                        BasicTextField(value = textField, onValueChange = {
                            textField = it
                            onValueChange(it)
                        })
                        if (textField.isBlank()){
                            MText14(text = hint, textRes = hintRes, color = LightGrey)
                        }
                    }
                }

                Image(painter = painterResource(id = painter), contentDescription = "TextField Icon")
            }
        }
    }
}

@Composable
fun MPasswordTextField(title:String?=null,titleRes:Int?=null,hint:String?=null,hintRes:Int?=null,onValueChange : (String) -> Unit){
    var textField by remember {
        mutableStateOf<String>("")
    }
    Column {
        MText16(text = title, textRes = titleRes)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = TFGrey)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)){
                    BasicTextField(value = textField, onValueChange = {
                        textField = it
                        onValueChange(it)
                    })
                    if (textField.isBlank()){
                        MText14(text = hint, textRes = hintRes, color = LightGrey)
                    }
                }
                Image(painter = painterResource(id = R.drawable.ic_password), contentDescription = "TextField Icon")
            }
        }
    }
}

@Composable
fun MSearchTextField(modifier: Modifier = Modifier,title:String?=null,titleRes:Int?=null,hint:String?=null,hintRes:Int?=null,onValueChange : (String) -> Unit){
    var textField by remember {
        mutableStateOf<String>("")
    }
    Column(modifier = modifier) {
        MText16(text = title, textRes = titleRes)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = LPrimaryColor)
            .border(width = 1.dp, shape = RoundedCornerShape(8.dp), color = Color.White)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id =  R.drawable.ic_search), contentDescription = "Search Icon")
                Row(modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)) {

                    Box(){
                        BasicTextField(value = textField, onValueChange = {
                            textField = it
                            onValueChange(it)
                        })
                        if (textField.isBlank()){
                            MText14(text = hint, textRes = hintRes, color = LightGrey)
                        }
                    }
                }


            }
        }
    }
}