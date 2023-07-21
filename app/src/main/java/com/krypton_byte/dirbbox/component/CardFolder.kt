package com.krypton_byte.dirbbox.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krypton_byte.dirbbox.R
import com.krypton_byte.dirbbox.screens.FolderModel
import com.krypton_byte.dirbbox.ui.theme.Gilroy

@Composable
fun CardFolder(folder: FolderModel, modifier: Modifier = Modifier){
    val modifiers = modifier.width(148.dp)
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = modifiers,
        colors = CardDefaults.cardColors(
            containerColor = folder.color
        )
    ) {
        Row(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = folder.icon), contentDescription = folder.name)
            Icon(painter = painterResource(id = R.drawable.more_option), contentDescription = "more option", tint = folder.content_color)
        }
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = folder.name,
            color = folder.content_color,
            fontSize = 15.sp,
            fontFamily = Gilroy,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = folder.date,
            color = folder.content_color,
            fontSize = 10.sp,
            fontFamily = Gilroy,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}