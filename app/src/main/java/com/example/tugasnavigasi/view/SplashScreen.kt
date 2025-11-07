package com.example.tugasnavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class SplashUser(
    val name: String = "Asyiraaf Nufail",
    val nim: String = "20230140079"
)

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    user: com.example.tugasnavigasi.view.SplashUser = SplashUser(),
    onSubmitClick: () -> Unit
){
    val bg = Color(0xFFF1ECFF)          // ungu sangat muda
    val primary = Color(0xFF5B3DF5)     // ungu tombol/aksen
    val textDark = Color(0xFF2E2A47)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(bg)
            .padding(horizontal = 24.dp)
    )
}