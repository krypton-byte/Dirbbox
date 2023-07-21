package com.krypton_byte.dirbbox.screens
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class NavRouteModel(
    val name: String,
    val route: Screen,
    var _active: Boolean = false,
    var active: MutableState<Boolean> = mutableStateOf(_active)
){
    companion object {
        fun set_active(route: NavRouteModel, routes: List<NavRouteModel>){
            for(r in routes){
                if(r.active.value && r != route){
                    r.active.value = false
                }else if(r == route){
                    r.active.value = true
                }
            }
        }

    }
}
