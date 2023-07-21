package com.example.custompiechartjc

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krypton_byte.dirbbox.R
import com.krypton_byte.dirbbox.component.ProgressBar
import com.krypton_byte.dirbbox.ui.theme.DarkBlue
import com.krypton_byte.dirbbox.ui.theme.Gilroy
import com.krypton_byte.dirbbox.ui.theme.Purple40

@Composable
fun PieChart(
    data: Map<String, Float>,
    radiusOuter: Dp = 90.dp,
    chartBarWidth: Dp = 20.dp,
    animDuration: Int = 1000,
) {

    val totalSum = data.values.sum()
    val floatValue = mutableListOf<Float>()
    val percentage = mutableListOf<Float>()

    // To set the value of each Arc according to
    // the value given in the data, we have used a simple formula.
    // For a detailed explanation check out the Medium Article.
    // The link is in the about section and readme file of this GitHub Repository
    data.values.forEachIndexed { index, values ->
        floatValue.add(index, 360 * values.toFloat() / totalSum.toFloat())
    }
    data.values.forEachIndexed { index, fl ->
        percentage.add(index, fl/totalSum * 1)
    }

    // add the colors as per the number of data(no. of pie chart entries)
    // so that each data will get a color
    val colors: List<Color> = listOf(
        Color(0xFF22215B),
        Color(0xFFFFC700),
        Color(0xFF4CE364),
        Color(0xFF567DF4),
        Color(0xFFFF842B)
    )

    var animationPlayed by remember { mutableStateOf(false) }

    var lastValue = 0f

    // it is the diameter value of the Pie
    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    // if you want to stabilize the Pie Chart you can use value -90f
    // 90f is used to complete 1/4 of the rotation
    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    // to play the animation only once when the function is Created or Recomposed
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Pie Chart using Canvas Arc
        Box(
            modifier = Modifier.size(animateSize.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .size(radiusOuter * 1.5f)
                    .rotate(animateRotation)
            ) {
                // draw each Arc for each data entry in Pie Chart
                floatValue.forEachIndexed { index, value ->
                    drawArc(
                        color = colors[index],
                        lastValue,
                        value,
                        useCenter = false,
                        style = Stroke(50.dp.toPx(), cap = StrokeCap.Butt)
                    )
                    lastValue += value
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Available", fontFamily = Gilroy, color = DarkBlue, fontSize = 20.sp)
        Text(text = "43.66 GB", fontFamily = Gilroy, color = DarkBlue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Total 128 GB", fontFamily = Gilroy, color = DarkBlue, fontSize = 20.sp)
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(top = 30.dp)) {
            data.values.forEachIndexed { index, fl ->
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(painter = painterResource(id = R.drawable.dot), contentDescription = null, tint = colors[index])
                                Spacer(modifier = Modifier.width(20.dp))
                                Text(text = data.keys.elementAt(index), fontFamily = Gilroy, fontSize = 18.sp, color = DarkBlue)
                            }
                            ProgressBar(color = colors[index], percentage = percentage[index])
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(id = R.drawable.dot), contentDescription = null, tint = Color.Transparent)
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "${fl} GB", fontSize = 12.sp, color = Color(0xFF22215B), fontFamily = Gilroy)
                        }
                    }

                }
            }
        }

    }

}
