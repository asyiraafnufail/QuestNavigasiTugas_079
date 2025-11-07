package com.example.tugasnavigasi.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class SplashUser(
    val name: String = "Asyiraaf Nufail",
    val nim: String = "20230140079"
)

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    user: com.example.navigasi.view.SplashUser = SplashUser(),
    onSubmitClick: () -> Unit
)