package com.krypton_byte.dirbbox

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.krypton_byte.dirbbox.screens.ChangePassword
import com.krypton_byte.dirbbox.screens.LoginActivity
import com.krypton_byte.dirbbox.ui.theme.DirbBoxTheme
import com.krypton_byte.dirbbox.screens.Dribbox
import com.krypton_byte.dirbbox.screens.MyProfile
import com.krypton_byte.dirbbox.screens.Screen
import com.krypton_byte.dirbbox.screens.Settings
import com.krypton_byte.dirbbox.screens.Storage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DirbBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Login.name){
                        composable(route = Screen.Login.name){
                            LoginActivity {
                                navController.navigate(Screen.Home.name)
                            }
                        }
                        composable(route = Screen.Home.name){
                            Dribbox(navController)
                        }
                        composable(route = Screen.Stat.name){
                            Dribbox(navController)
                        }
                        composable(route = Screen.Shared.name){
                            Dribbox(navController)
                        }
                        composable(route = Screen.Help.name){
                            Dribbox(navController)
                        }
                        composable(route = Screen.MyProfile.name){
                            MyProfile(navController)
                        }
                        composable(route = Screen.Storage.name){
                            Storage(navController)
                        }
                        composable(route = Screen.Settings.name){
                            Settings(navController)
                        }
                        composable(route = Screen.ChangePassword.name){
                            ChangePassword(navController)
                        }
                    }
//                    LoginActivity(){
//                        val toast = Toast(applicationContext)
//                        toast.setText("Sign")
//                        toast.duration = Toast.LENGTH_SHORT
//                        toast.show()
//                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DirbBoxTheme {
        Greeting("Android")
    }
}