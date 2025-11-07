package com.example.tugasnavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Selamat Datang",
                fontSize = 36.sp,
                color = textDark,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp,
                modifier = Modifier.padding(bottom = 28.dp)
            )
            PlanetBadge(
                title = "CARD-LST",
                subtitle = "MOBILE APP",
                year = "2025",
                primary = primary,
                textColor = textDark
            )
        }
    }
}

