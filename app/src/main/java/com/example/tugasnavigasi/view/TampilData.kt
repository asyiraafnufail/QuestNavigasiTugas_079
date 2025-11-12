package com.example.tugasnavigasi.view // Menentukan package tempat file ini berada

// ===== Import library Jetpack Compose yang digunakan =====
import androidx.compose.foundation.layout.* // Untuk pengaturan tata letak (Column, Spacer, Padding, dll.)
import androidx.compose.material3.* // Untuk komponen Material 3 (Scaffold, Button, Text, TopAppBar, dll.)
import androidx.compose.runtime.Composable // Menandai fungsi sebagai composable (bisa digunakan di UI Compose)
import androidx.compose.ui.Modifier // Untuk memodifikasi tampilan composable
import androidx.compose.ui.graphics.Color // Untuk warna
import androidx.compose.ui.res.colorResource // Mengambil warna dari resource XML
import androidx.compose.ui.res.dimensionResource // Mengambil ukuran dari resource XML
import androidx.compose.ui.res.stringResource // Mengambil string dari resource XML
import androidx.compose.ui.text.font.FontFamily // Untuk menentukan jenis font
import androidx.compose.ui.text.font.FontWeight // Untuk ketebalan font
import androidx.compose.ui.unit.dp // Satuan ukuran (density-independent pixel)
import androidx.compose.ui.unit.sp // Satuan ukuran teks (scale-independent pixel)
import com.example.tugasnavigasi.R // Mengimpor resource (warna, teks, dimensi, dll.) dari folder res

@OptIn(ExperimentalMaterial3Api::class) // Mengaktifkan fitur eksperimental dari Material 3 (TopAppBar)
@Composable
fun TampilData(
    onGoFormulir: () -> Unit,   // Fungsi callback untuk pindah ke halaman Formulir
    onGoSplash: () -> Unit      // Fungsi callback untuk kembali ke halaman Splash (Beranda)
){
    // ===== Daftar data yang akan ditampilkan di layar =====
    val items = listOf(
        Pair(stringResource(id = R.string.nama_lengkap), "Contoh Nama"), // Nama
        Pair(stringResource(id = R.string.jenis_kelamin), "Lainnya"),    // Jenis kelamin
        Pair(stringResource(id = R.string.aLamat), "Yogyakarta")         // Alamat
    )

    // ===== Struktur utama menggunakan Scaffold =====
    Scaffold(
        topBar = { // Bagian atas layar (AppBar)
            TopAppBar(
                title = { // Judul AppBar
                    Text(
                        text = stringResource(id = R.string.tampil), // Teks dari resource string.xml
                        color = Color.White // Warna teks putih
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    colorResource(id = R.color.teal_700) // Warna latar AppBar dari resource warna
                )
            )
        }
    ){
            isiRuang -> // Parameter padding otomatis dari Scaffold
        Column(
            modifier = Modifier
                .padding(isiRuang) // Menyesuaikan padding konten dengan AppBar
                .fillMaxSize(), // Mengisi seluruh layar
            verticalArrangement = Arrangement.SpaceBetween // Elemen dibagi atas dan bawah
        ){
            // ===== Kolom bagian atas: Menampilkan data =====
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)), // Padding dari resource dimens.xml
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)) // Jarak antar elemen
            ){
                items.forEach { item -> // Loop untuk menampilkan setiap data (label dan nilai)
                    Column {
                        Text(
                            text = item.first.uppercase(), // Label data (huruf besar semua)
                            fontSize = 16.sp
                        )
                        Text(
                            text = item.second, // Nilai data
                            fontWeight = FontWeight.Bold, // Teks tebal
                            fontFamily = FontFamily.Cursive, // Font gaya tulisan tangan
                            fontSize = 22.sp
                        )
                    }
                    // Garis pembatas antar data
                    HorizontalDivider(thickness = 1.dp, color = Color.Cyan)
                }
            }

            // ===== Kolom bagian bawah: Tombol navigasi =====
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ){
                // Tombol kembali ke beranda (Splash)
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = onGoSplash // Aksi ketika tombol ditekan
                ) {
                    Text(text = "Beranda")
                }

                Spacer(Modifier.height(12.dp)) // Jarak antar tombol

                // Tombol menuju ke Formulir Pendaftaran
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = onGoFormulir // Aksi ketika tombol ditekan
                ) {
                    Text(text = stringResource(id = R.string.formulir_pendaftaran))
                }
            }
        }
    }
}
