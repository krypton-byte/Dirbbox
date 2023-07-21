package com.krypton_byte.dirbbox.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.krypton_byte.dirbbox.R
import com.krypton_byte.dirbbox.component.SwitchButton
import com.krypton_byte.dirbbox.ui.theme.Gilroy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navhost: NavHostController){
    Scaffold(topBar = {
        Column(modifier = Modifier.padding(start = 31.dp, end = 31.dp, top = 50.dp)) {
            Icon(painter = painterResource(R.drawable.back), contentDescription = null, modifier = Modifier.clickable {
                navhost.navigate(Screen.Home.name)
            })
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Setting", fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = Gilroy)
            Spacer(modifier = Modifier.height(30.dp))
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
        ) {
                item(){
                    Text(
                        text = "Add Account", modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 10.dp),
                        color = Color(0xFF1B1D28),
                        fontFamily = Gilroy,
                        fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                    )
                }
                item {
                    Text(text = "Change Password", modifier = Modifier
                        .clickable {
                            navhost.navigate(Screen.ChangePassword.name)
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 10.dp),
                        color = Color(0xFF1B1D28),
                        fontFamily = Gilroy,
                        fontSize = 16.sp,
                    fontWeight = FontWeight.Medium)
                }
                items(listOf("Change Language", "Upgrade Plan", "Multiple Account")) {
                    Text(text = it, modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 10.dp),
                    color = Color(0xFF1B1D28),
                    fontFamily = Gilroy,
                    fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
                items(listOf("Enable Sync", "Enable 2 Step Verification")){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = it,
                            color = Color(0xFF1B1D28),
                            fontFamily = Gilroy,
                            fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                        SwitchButton(thumbSize = 11.dp, height = 20.dp, width = 34.dp, gapBetweenThumbAndTrackEdge = 5.dp)
                    }
                }
        }
    }
}