package com.krypton_byte.dirbbox.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.custompiechartjc.PieChart
import com.krypton_byte.dirbbox.R
import com.krypton_byte.dirbbox.component.CardFolder
import com.krypton_byte.dirbbox.ui.theme.BlueFolder
import com.krypton_byte.dirbbox.ui.theme.ContentBlueFolder
import com.krypton_byte.dirbbox.ui.theme.ContentCyanFolder
import com.krypton_byte.dirbbox.ui.theme.ContentRedFolder
import com.krypton_byte.dirbbox.ui.theme.ContentYellowFolder
import com.krypton_byte.dirbbox.ui.theme.CyanFolder
import com.krypton_byte.dirbbox.ui.theme.DarkBlue
import com.krypton_byte.dirbbox.ui.theme.Gilroy
import com.krypton_byte.dirbbox.ui.theme.RedFolder
import com.krypton_byte.dirbbox.ui.theme.YellowFolder


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Storage(navhost: NavHostController){
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xfffdfdfd)),
        containerColor = Color(0xfffdfdfd),
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 31.dp, end = 31.dp, top = 50.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(painter = painterResource(id = R.drawable.back), contentDescription = null, modifier = Modifier.clickable {
                    navhost.navigate(Screen.Home.name)
                })
                Text(text = "My Profile", fontSize = 16.sp, fontFamily = Gilroy, fontWeight = FontWeight.SemiBold, color = DarkBlue)
                Icon(painter = painterResource(id = R.drawable.three_dots), contentDescription = null)
            }
        },
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Column() {
                PieChart(data = mapOf(
                    Pair("Design Files", 38.66f),
                    Pair("Images", 24.80f),
                    Pair("Video", 12.60f),
                    Pair("Decuments", 60.57f),
                    Pair("Others", 2.01f)
                ))
            }
            Text(text = "Export Details", fontFamily = Gilroy, color = DarkBlue, fontSize = 16.sp, modifier = Modifier.padding(bottom = 20.dp))

        }
    }
}