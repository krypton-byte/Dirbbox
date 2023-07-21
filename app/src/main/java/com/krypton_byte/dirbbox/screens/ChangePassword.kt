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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassword(navhost: NavHostController){
    Scaffold(topBar = {
        Column(modifier = Modifier.padding(start = 31.dp, end = 31.dp, top = 50.dp)) {
            Icon(painter = painterResource(R.drawable.back), contentDescription = null, modifier = Modifier.clickable {
                navhost.navigate(Screen.Home.name)
            })
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Change Password", fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = Gilroy)
            Spacer(modifier = Modifier.height(50.dp))
        }
    }, containerColor = Color.White) {
        LazyColumn(modifier = Modifier.padding(it), verticalArrangement = Arrangement.spacedBy(30.dp)){
            items(listOf("Current Password", "New Password", "Confirm new password")){
                var inputPassword by remember {
                    mutableStateOf("")
                }
                Column(modifier = Modifier
                    .padding(horizontal = 31.dp)) {
                    Text(text = it, fontFamily = Gilroy, color = Color(0xFF1B1D28), fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = inputPassword, onValueChange = { inputPassword += it},
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xFFEEF2FE)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}