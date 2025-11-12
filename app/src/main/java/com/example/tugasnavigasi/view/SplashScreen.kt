package com.example.tugasnavigasi.view // Menentukan package tempat file ini berada

// ===== Impor library Jetpack Compose yang digunakan =====
import androidx.compose.foundation.Canvas // Untuk menggambar bentuk 2D (lingkaran, garis, dll.)
import androidx.compose.foundation.background // Untuk memberi warna latar belakang pada elemen
import androidx.compose.foundation.layout.* // Untuk mengatur tata letak (Column, Box, Spacer, dsb.)
import androidx.compose.foundation.shape.RoundedCornerShape // Untuk membuat bentuk dengan sudut membulat
import androidx.compose.material3.Button // Komponen tombol dari Material 3
import androidx.compose.material3.ButtonDefaults // Untuk mengatur warna & elevasi tombol
import androidx.compose.material3.Text // Komponen teks
import androidx.compose.runtime.Composable // Menandai fungsi yang bisa digunakan sebagai UI Compose
import androidx.compose.ui.Alignment // Untuk mengatur perataan elemen (horizontal/vertikal)
import androidx.compose.ui.Modifier // Modifier untuk memodifikasi tampilan composable
import androidx.compose.ui.geometry.Offset // Titik koordinat untuk menggambar di Canvas
import androidx.compose.ui.graphics.Color // Untuk mendefinisikan warna
import androidx.compose.ui.graphics.StrokeCap // Bentuk ujung garis (bulat, datar, dll.)
import androidx.compose.ui.graphics.drawscope.Stroke // Menggambar bentuk berisi garis (bukan isi warna)
import androidx.compose.ui.text.font.FontWeight // Ketebalan teks
import androidx.compose.ui.text.style.TextAlign // Perataan teks (kiri, tengah, kanan)
import androidx.compose.ui.unit.dp // Satuan ukuran density-independent pixel
import androidx.compose.ui.unit.sp // Satuan ukuran font (scale-independent pixel)

// ===== Data class sederhana untuk menyimpan data pengguna Splash =====
data class SplashUser(
    val name: String = "Asyiraaf Nufail", // Nama default
    val nim: String = "20230140079"        // NIM default
)

// ===== Composable utama untuk tampilan Splash Screen =====
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier, // Modifier opsional untuk fleksibilitas tampilan
    user: com.example.tugasnavigasi.view.SplashUser = SplashUser(), // Data pengguna yang akan ditampilkan
    onSubmitClick: () -> Unit // Lambda (fungsi) yang dipanggil saat tombol ditekan
){
    // Warna tema
    val bg = Color(0xFFF1ECFF)          // Warna latar ungu muda
    val primary = Color(0xFF5B3DF5)     // Warna utama (ungu gelap)
    val textDark = Color(0xFF2E2A47)    // Warna teks gelap

    // ===== Struktur utama menggunakan Box =====
    Box(
        modifier = modifier
            .fillMaxSize() // Mengisi seluruh layar
            .background(bg) // Memberi latar belakang warna ungu muda
            .padding(horizontal = 24.dp) // Memberi jarak kiri-kanan
    ){
        // ===== Isi konten utama =====
        Column(
            modifier = Modifier.fillMaxSize(), // Kolom memenuhi layar
            horizontalAlignment = Alignment.CenterHorizontally, // Semua elemen sejajar di tengah
            verticalArrangement = Arrangement.Center // Semua elemen diratakan di tengah vertikal
        ){
            // Judul utama
            Text(
                text = "Selamat Datang",
                fontSize = 36.sp,
                color = textDark,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp,
                modifier = Modifier.padding(bottom = 28.dp)
            )

            // Menampilkan lencana (badge) planet custom
            PlanetBadge(
                title = "CARD-LST",
                subtitle = "MOBILE APP",
                year = "2025",
                primary = primary,
                textColor = textDark
            )

            Spacer(Modifier.height(32.dp)) // Jarak antar elemen

            // Menampilkan nama pengguna
            Text(
                text = user.name,
                fontSize = 20.sp,
                color = textDark,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(4.dp)) // Jarak kecil antar teks

            // Menampilkan NIM pengguna
            Text(
                text = user.nim,
                fontSize = 14.sp,
                color = textDark.copy(alpha = 0.6f), // Warna teks lebih transparan
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(36.dp)) // Jarak sebelum tombol

            // Tombol “Submit” untuk berpindah ke layar berikutnya
            Button(
                onClick = onSubmitClick, // Aksi ketika tombol ditekan
                shape = RoundedCornerShape(28.dp), // Membuat tombol dengan ujung membulat
                modifier = Modifier
                    .fillMaxWidth() // Tombol selebar layar
                    .height(52.dp), // Tinggi tombol
                colors = ButtonDefaults.buttonColors(
                    containerColor = primary, // Warna latar tombol
                    contentColor = Color.White // Warna teks tombol
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp) // Menghapus efek bayangan
            ) {
                Text("Submit", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

// ===== Composable untuk membuat lencana (badge) dengan gambar planet =====
@Composable
private fun PlanetBadge(
    title: String, // Judul besar (misalnya CARD-LST)
    subtitle: String, // Subjudul kecil (misalnya MOBILE APP)
    year: String, // Tahun yang ditampilkan di pita
    primary: Color, // Warna utama elemen
    textColor: Color // Warna teks
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) { // Semua elemen sejajar di tengah

        // ===== Teks atas (judul) =====
        Text(
            text = title,
            fontSize = 24.sp,
            color = primary,
            fontWeight = FontWeight.Black,
            letterSpacing = 2.sp // Spasi antar huruf
        )

        Spacer(Modifier.height(8.dp))

        // ===== Menggambar planet dan cincin menggunakan Canvas =====
        Canvas(modifier = Modifier.size(120.dp)) {
            val center = Offset(size.width / 2, size.height / 2) // Titik tengah kanvas
            val radius = size.minDimension * 0.22f // Ukuran planet

            // Menggambar planet utama (lingkaran)
            drawCircle(color = Color(0xFFFF6FAF), radius = radius, center = center)

            // Menggambar cincin planet (garis melengkung)
            drawArc(
                color = primary,
                startAngle = 200f,
                sweepAngle = 140f,
                useCenter = false,
                style = Stroke(width = 16f, cap = StrokeCap.Round) // Garis dengan ujung bulat
            )

            // Menggambar bintang kecil di sekitar planet
            drawCircle(color = Color(0xFFFF6FAF), radius = 5f, center = center + Offset(-48f, -36f))
            drawCircle(color = Color(0xFFFF6FAF), radius = 4f, center = center + Offset(52f, -28f))
        }

        // ===== Subjudul dan pita tahun =====
        Text(
            text = subtitle,
            fontSize = 12.sp,
            color = textColor.copy(alpha = 0.7f),
            letterSpacing = 2.sp
        )
        Spacer(Modifier.height(6.dp))

        // Pita tahun dengan latar ungu
        Box(
            modifier = Modifier
                .background(primary, RoundedCornerShape(10.dp)) // Latar berbentuk kotak membulat
                .padding(horizontal = 12.dp, vertical = 4.dp) // Jarak di dalam kotak
        ) {
            Text(text = year, color = Color.White, fontSize = 12.sp) // Tahun di atas pita
        }
    }
}
