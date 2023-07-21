package com.krypton_byte.dirbbox.screens

import android.util.LayoutDirection
import android.util.Log
import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krypton_byte.dirbbox.R
import com.krypton_byte.dirbbox.ui.theme.Blue
import com.krypton_byte.dirbbox.ui.theme.DarkBlue
import com.krypton_byte.dirbbox.ui.theme.Gilroy
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.navigation.NavHostController
import com.krypton_byte.dirbbox.component.CardFolder
import com.krypton_byte.dirbbox.ui.theme.BlueFolder
import com.krypton_byte.dirbbox.ui.theme.ContentBlueFolder
import com.krypton_byte.dirbbox.ui.theme.ContentCyanFolder
import com.krypton_byte.dirbbox.ui.theme.ContentRedFolder
import com.krypton_byte.dirbbox.ui.theme.ContentYellowFolder
import com.krypton_byte.dirbbox.ui.theme.CyanFolder
import com.krypton_byte.dirbbox.ui.theme.RedFolder
import com.krypton_byte.dirbbox.ui.theme.YellowFolder





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideBar(
    navhost: NavHostController,
    close: (() -> Unit)? = null
){
    val drawer: List<NavRouteModel> = listOf(
        NavRouteModel("Home",Screen.Home, true),
        NavRouteModel("Profile", Screen.MyProfile),
        NavRouteModel("Storage", Screen.Storage),
        NavRouteModel("Shared", Screen.Shared),
        NavRouteModel("Stat", Screen.Stat),
        NavRouteModel("Settings", Screen.Settings),
        NavRouteModel("Help", Screen.Help)
    )
    ModalDrawerSheet(
        drawerTonalElevation = 0.dp,
        drawerShape = RoundedCornerShape(0.dp),
        drawerContainerColor = Color(241, 243, 246), //.width(DrawerDefaults.MaximumDrawerWidth)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.user_shape), contentDescription = null)
            Icon(modifier = Modifier
                .padding(end = 15.dp)
                .clickable {
                    if (close != null) {
                        close()
                    }
                }, imageVector = Icons.Default.Close, contentDescription = "close", tint = Color(0xFF3A4276))
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 70.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(drawer){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable {
                                NavRouteModel.set_active(it, drawer)
                                navhost.navigate(it.route.name)
                            }
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.rectangle_20),
                            contentDescription = null,
                            tint = if (it.active.value) Blue else Color.Transparent
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = it.name,
                            fontSize = 16.sp,
                            fontFamily = Gilroy,
                            fontWeight = if(it.active.value) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }
            Column(Modifier.padding(25.dp)) {
                Row() {
                    Icon(painter = painterResource(id = R.drawable.power), contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Power",
                        fontFamily = Gilroy,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B1D28)
                    )
                }
                Spacer(modifier = Modifier.height(62.dp))
                Text("Version 2.0.1", fontSize = 10.sp, fontFamily = Gilroy, fontWeight = FontWeight.Normal)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dribbox(navhost: NavHostController){
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val folders: List<FolderModel> = listOf(
        FolderModel("Mobile Apps", "December 20.2020", BlueFolder, ContentBlueFolder, R.drawable.blue_folder),
        FolderModel("SVG Icons", "December 14.2020", YellowFolder, ContentYellowFolder, R.drawable.yellow_folder),
        FolderModel("Prototypes", "November 22.2020", RedFolder, ContentRedFolder, R.drawable.red_folder),
        FolderModel("Avatars", "November 10.2020", CyanFolder, ContentCyanFolder, R.drawable.cyan_folder)
    )
    val box_folders = folders.toMutableList()
    for(i in 0..10){
        for(folder in folders){
            box_folders.add(folder)
        }
    }
    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            SideBar(navhost, close = {
                scope.launch {
                    drawerState.close()
                }
            })
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Scaffold(
            containerColor = Color(255, 255, 255),
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.padding(end = 20.dp, bottom = 30.dp),
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    containerColor = DarkBlue,
                    contentColor = Color.White
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }},
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Your Dribbbox",
                        fontFamily = Gilroy,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = DarkBlue
                    )
                    Icon(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                scope.launch {
                                    drawerState.open()
                                    Log.i("OPEN", drawerState.isOpen.toString())
                                }
                            },
                        painter = painterResource(id = R.drawable.union),
                        contentDescription = null, tint = DarkBlue
                    )
                }
            },

            ) {

                var search by remember {
                    mutableStateOf("")
                }
                    Column(
                        Modifier
                            .padding(it)
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            placeholder = {Text("Search Folder")},
                            value = search,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                ) },
                            onValueChange = {
                                search = it },
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    Color(238, 242, 254),
                                    TextFieldDefaults.outlinedShape
                                )
                                .fillMaxWidth()
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Recent",
                                    color = DarkBlue,
                                    fontSize = 15.sp,
                                    fontFamily = Gilroy,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = DarkBlue
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null,
                                    tint = Color(0xFFB0C0D0)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.windows),
                                    contentDescription = null,
                                    tint = DarkBlue
                                )
                            }
                        }
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(top = 20.dp)
                        ){
                            items(box_folders.toList()){ folder ->
                               CardFolder(folder = folder)
                            }
                        }

                }
        }
    }
}