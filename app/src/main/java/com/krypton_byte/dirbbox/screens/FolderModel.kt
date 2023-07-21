package com.krypton_byte.dirbbox.screens

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class FolderModel(
    val name: String,
    val date: String,
    val color: Color,
    val content_color: Color,
    val icon: Int
)
