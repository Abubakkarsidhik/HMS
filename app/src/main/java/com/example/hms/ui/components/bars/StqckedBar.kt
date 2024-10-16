package com.example.hms.ui.components.bars

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hms.ui.theme.LPrimaryColor
import kotlinx.coroutines.delay

data class Slice(val value: Float, val color: Color, val text: String = "")

@Preview
@Composable
fun StackedBar(modifier: Modifier = Modifier.height(64.dp).clip(RoundedCornerShape(8.dp))) {
    val slices = listOf(
        Slice(value = 74.6f, color = Color.Cyan, text = "74"),
        Slice(value = 31.8f, color = Color.Yellow, text = "31"),
    )

    var state by remember { mutableStateOf(.0f) }
    val width = animateFloatAsState(targetValue = state, animationSpec = tween(300))

    LaunchedEffect(key1 = Unit, block = {
        delay(1000L)
        state = 1f
    })

    Row(
        modifier = modifier,
    ) {
        slices.forEach {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(it.value),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /*Text(
                    text = it.value.toString(),
                    color = Color.Black,
                    modifier = Modifier.padding(4.dp)
                )*/
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(it.color),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "${it.text} %", color = LPrimaryColor)
                }
            }
        }
    }
}