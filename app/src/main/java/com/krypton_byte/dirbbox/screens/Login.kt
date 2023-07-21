package com.krypton_byte.dirbbox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krypton_byte.dirbbox.R
import com.krypton_byte.dirbbox.ui.theme.DarkBlue
import com.krypton_byte.dirbbox.ui.theme.Gilroy


@Composable
fun LoginActivity(onsignclick: ()-> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.illustration),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.padding(start = 30.dp)) {
                Text(
                    modifier = Modifier.padding(top=5.dp),
                    text = "Wellcome To",
                    fontSize = 20.sp,
                    fontFamily = Gilroy,
                    color = DarkBlue
                )
                Text(
                    modifier = Modifier.padding(top=5.dp),
                    text = "Dirbbox",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(34, 33, 91),
                    fontFamily = Gilroy
                )
                Text(text = "Best cloud storage platform for all business and individuals to manage there data",
                    modifier = Modifier.width(223.dp).padding(top=15.dp),
                    color = Color(123, 127, 158),
                    fontSize = 14.sp,
                    fontFamily = Gilroy
                )
                Text(
                    modifier = Modifier.padding(top=30.dp),
                    text = "Join For Free.",
                    color = Color(123, 127, 158),
                    fontFamily = Gilroy,
                    fontSize = 14.sp
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),horizontalArrangement = Arrangement.SpaceAround) {
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(86, 125, 244, 25),
                        contentColor = Color(86, 125, 244)
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_fingerprint_24),
                        contentDescription = null
                    )
                    Text(
                        text = "Smart id",
                        modifier = Modifier.padding(start = 3.dp),
                        fontSize = 16.sp, fontFamily = Gilroy,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    onClick = {
                        onsignclick()
                    },
                    shape = RoundedCornerShape(9.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(86, 125, 244),
                        contentColor =  Color.White
                    )
                ) {
                    Text(
                        text = "Sign in",
                        fontSize = 16.sp,
                        fontFamily = Gilroy,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(modifier = Modifier.padding(start = 10.dp),painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Use Social Login",
                textAlign = TextAlign.Center,
                fontFamily = Gilroy
            )
            Row(modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Image(modifier = Modifier.size(20.dp), painter = painterResource(id = R.drawable.instagram_logo), contentDescription = null)
                Image(modifier = Modifier.size(20.dp), painter = painterResource(id = R.drawable.twitter_logo), contentDescription = null)
                Image(modifier = Modifier.size(20.dp), painter = painterResource(id = R.drawable.facebook_logo), contentDescription = null)
            }
        }
        Text(
            modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
            text = "Create An Account",
            textAlign = TextAlign.Center,
            color = Color(27, 29, 40)
        )
    }
}