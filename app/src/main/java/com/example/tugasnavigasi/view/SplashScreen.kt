package com.example.tugasnavigasi.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

            Spacer(Modifier.height(32.dp))

            Text(
                text = user.name,
                fontSize = 20.sp,
                color = textDark,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = user.nim,
                fontSize = 14.sp,
                color = textDark.copy(alpha = 0.6f),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(36.dp))

            Button(
                onClick = onSubmitClick,
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primary,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Text("Submit", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
private fun PlanetBadge(
    title: String,
    subtitle: String,
    year: String,
    primary: Color,
    textColor: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        // Teks atas (CARD-LST) gaya melengkung sederhana (pakai huruf besar & spasi)
        Text(
            text = title,
            fontSize = 24.sp,
            color = primary,
            fontWeight = FontWeight.Black,
            letterSpacing = 2.sp
        )

        Spacer(Modifier.height(8.dp))

        // Planet pakai Canvas
        Canvas(modifier = Modifier.size(120.dp)) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension * 0.22f

            // planet (lingkaran)
            drawCircle(color = Color(0xFFFF6FAF), radius = radius, center = center)

            // cincin
            drawArc(
                color = primary,
                startAngle = 200f,
                sweepAngle = 140f,
                useCenter = false,
                style = Stroke(width = 16f, cap = StrokeCap.Round)
            )

            // titik bintang kecil
            drawCircle(color = Color(0xFFFF6FAF), radius = 5f, center = center + Offset(-48f, -36f))
            drawCircle(color = Color(0xFFFF6FAF), radius = 4f, center = center + Offset(52f, -28f))
        }

        // Subtitle & pita tahun
        Text(
            text = subtitle,
            fontSize = 12.sp,
            color = textColor.copy(alpha = 0.7f),
            letterSpacing = 2.sp
        )
        Spacer(Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(primary, RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(text = year, color = Color.White, fontSize = 12.sp)
        }
    }
}
