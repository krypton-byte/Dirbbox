package com.krypton_byte.dirbbox.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krypton_byte.dirbbox.ui.theme.Purple40
import com.krypton_byte.dirbbox.ui.theme.Purple80


@Composable
fun ProgressBar(
    color: Color,
    percentage: Float
){
    var progress by remember {
        mutableStateOf(0f)
    }
    val size by animateFloatAsState(targetValue = progress, tween(durationMillis = 1000, delayMillis = 200, easing = LinearOutSlowInEasing))
    Column() {
        // Progress Bar
        Box(modifier = Modifier
            .height(4.dp).width(120.dp)){
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(9.dp))
                .background(
                    Color(0xFFEEF7FE)
                ),
            contentAlignment = Alignment.CenterEnd
            ){
                Box(modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(
                        color
                    )
                    .animateContentSize()
                )
            }
        }
    }
    LaunchedEffect(key1 = true){
        progress = percentage
    }
}