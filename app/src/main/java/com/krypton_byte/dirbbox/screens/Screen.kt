package com.krypton_byte.dirbbox.screens

sealed class Screen(
    val name: String
){
    object Login: Screen("Login")
    object Home: Screen("Home")
    object MyProfile: Screen("MyProfile")
    object Storage: Screen("Storage")
    object Shared: Screen("Shared")
    object Stat: Screen("Stat")
    object Settings: Screen("Settings")
    object Help: Screen("Help")
    object ChangePassword: Screen("Change Password")
}