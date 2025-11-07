package com.example.tugasnavigasi.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

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
}