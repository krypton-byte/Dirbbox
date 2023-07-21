package com.krypton_byte.dirbbox.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MyProfile(navhost: NavHostController){
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
        }
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 10.dp, end = 31.dp, start = 31.dp)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Column(
                modifier = Modifier
                    .shadow(elevation = 1.dp, shape = CardDefaults.shape)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(15.dp),
                    contentAlignment = Alignment.TopEnd,
                ){
                    Surface(
                        tonalElevation = 81.dp,
                        shadowElevation = 9.dp,
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFFFF317B),
                        contentColor = Color.White
                    ) {
                        Text(text = "PRO", modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp))

                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                        .background(Color.Transparent), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id = R.drawable.profile_image), contentDescription = null)
                        Text("Neelesh Chaudhary", fontFamily = Gilroy, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = DarkBlue, modifier = Modifier.padding(top = 16.dp))
                        Text(text = "UI / UX Designer", fontFamily = Gilroy, fontSize = 13.sp, color = DarkBlue, fontWeight = FontWeight.Normal)
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ornare pretium placerat ut platea.",
                            modifier = Modifier.padding(top=20.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp,
                            fontFamily = Gilroy,
                            color = Color(0xFF22215B)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "My Folder", fontSize = 15.sp, fontFamily = Gilroy, fontWeight = FontWeight.SemiBold, color = DarkBlue)
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(100.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.add), contentDescription = null)
                    Icon(painter = painterResource(id = R.drawable.settings), contentDescription = null)
                    Icon(painter = painterResource(id = R.drawable.forward), contentDescription = null)
                }
            }
            val folders: List<FolderModel> = listOf(
                FolderModel("Mobile Apps", "December 20.2020", BlueFolder, ContentBlueFolder, R.drawable.blue_folder),
                FolderModel("SVG Icons", "December 14.2020", YellowFolder, ContentYellowFolder, R.drawable.yellow_folder),
                FolderModel("Prototypes", "November 22.2020", RedFolder, ContentRedFolder, R.drawable.red_folder),
                FolderModel("Avatars", "November 10.2020", CyanFolder, ContentCyanFolder, R.drawable.cyan_folder)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ){
                val foldersSize = folders.size
                for(n_folder in 0 until foldersSize step 2){
                    Log.i("tap", n_folder.toString())
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        CardFolder(folder = folders[n_folder])
                        if(foldersSize > n_folder + 1)
                        CardFolder(folder = folders[n_folder + 1])
                    }
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Recent Update", fontFamily = Gilroy, color = DarkBlue, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Icon(painter = painterResource(id = R.drawable.sort), contentDescription = null)
            }
            Row(modifier = Modifier
                .padding(top = 17.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(shape = CircleShape, colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFeef7fe)
                    )) {
                        Image(painter = painterResource(id = R.drawable.word), contentDescription = null, modifier = Modifier.padding(10.dp))
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Projects.docx", fontFamily = Gilroy, color = DarkBlue, fontSize = 15.sp, fontWeight = FontWeight.Normal)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "November 22.20", fontFamily = Gilroy, color = Color(0xFF22215B), fontSize = 11.sp, fontWeight = FontWeight.Normal)
                            Text(text = "300 kb", fontFamily = Gilroy, color = Color(0xFF22215B), fontSize = 11.sp, fontWeight = FontWeight.Normal)
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

        }
    }
}