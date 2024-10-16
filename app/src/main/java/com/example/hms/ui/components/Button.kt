package com.example.hms.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hms.ui.theme.LPrimaryColor

object MButton {
    val modifier = Modifier
        .height(55.dp)
        .fillMaxWidth()
}
@Composable
fun MFilledButton(modifier: Modifier = MButton.modifier ,label : String? = null, labelRes :Int? = null, onClick :() -> Unit){

    Button(onClick = onClick, modifier =  modifier, shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(containerColor = LPrimaryColor)) {
        MTextBold20(text = label, textRes = labelRes, color = Color.White)
    }

}

@Composable
fun MOutlinedButton(modifier: Modifier = MButton.modifier ,label : String? = null, labelRes :Int? = null, onClick :() -> Unit){
    OutlinedButton(onClick = onClick, modifier =  modifier, shape = RoundedCornerShape(8.dp), border = BorderStroke(width = 1.dp, LPrimaryColor)) {
        MTextBold20(text = label, textRes = labelRes)
    }

}