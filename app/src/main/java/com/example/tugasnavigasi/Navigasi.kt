package com.example.tugasnavigasi // Menentukan package tempat file ini berada

import androidx.compose.foundation.layout.padding // Modifier untuk memberi jarak (padding) pada elemen UI
import androidx.compose.material3.Scaffold // Struktur layout dasar (memiliki slot seperti topBar, content, dsb.)
import androidx.compose.runtime.Composable // Anotasi untuk menandai fungsi sebagai Composable (UI dengan Jetpack Compose)
import androidx.compose.ui.Modifier // Modifier digunakan untuk memodifikasi tampilan composable
import androidx.navigation.NavHostController // Controller yang mengatur perpindahan (navigasi) antar layar
import androidx.navigation.compose.NavHost // Container utama yang menampung dan mengatur navigasi antar composable
import androidx.navigation.compose.composable // Fungsi untuk mendefinisikan setiap layar (destination)
import androidx.navigation.compose.rememberNavController // Membuat dan mengingat NavController selama komposisi aktif
import com.example.tugasnavigasi.view.FormulirPendaftaran // Mengimpor composable FormulirPendaftaran
import com.example.tugasnavigasi.view.TampilData // Mengimpor composable TampilData
import com.example.tugasnavigasi.view.SplashScreen // Mengimpor composable SplashScreen

// Enum class untuk mendefinisikan semua rute (halaman) navigasi
enum class Navigasi {
    Formulirku, // Halaman formulir pendaftaran
    Detail,     // Halaman tampilan data
    Splash      // Halaman splash screen (halaman pembuka)
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(), // Controller untuk mengatur navigasi antar layar
    modifier: Modifier = Modifier // Modifier opsional agar bisa disesuaikan dari luar
) {
    Scaffold { isiRuang -> // Scaffold sebagai wadah utama layout, menyediakan area konten
        // NavHost mengatur dan menampilkan layar sesuai rute aktif
        NavHost(
            navController = navController, // Menghubungkan NavHost dengan controller navigasi
            startDestination = Navigasi.Splash.name, // Menentukan layar awal aplikasi (SplashScreen)
            modifier = Modifier.padding(isiRuang) // Memberi padding agar konten tidak tertutup Scaffold
        ) {
            // ===== Splash Screen =====
            composable(route = Navigasi.Splash.name) { // Mendefinisikan rute untuk SplashScreen
                SplashScreen(
                    onSubmitClick = {
                        // Saat tombol ditekan, navigasi ke layar TampilData
                        navController.navigate(Navigasi.Detail.name) {
                            popUpTo(Navigasi.Splash.name) { inclusive = true } // Menghapus Splash dari tumpukan navigasi
                            launchSingleTop = true // Mencegah pembuatan ulang layar jika sudah di atas stack
                        }
                    }
                )
            }

            // ===== TampilData Screen =====
            composable(route = Navigasi.Detail.name) { // Mendefinisikan rute untuk halaman TampilData
                TampilData(
                    onGoFormulir = {
                        // Navigasi ke halaman Formulir Pendaftaran
                        navController.navigate(Navigasi.Formulirku.name) {
                            popUpTo(Navigasi.Detail.name) { inclusive = true } // Menghapus halaman TampilData dari stack
                            launchSingleTop = true // Menghindari duplikasi layar
                        }
                    },
                    onGoSplash = {
                        // Navigasi kembali ke halaman SplashScreen
                        navController.navigate(Navigasi.Splash.name) {
                            popUpTo(Navigasi.Splash.name) { inclusive = true } // Menghapus halaman lain dari stack
                            launchSingleTop = true // Pastikan hanya satu instance Splash aktif
                        }
                    }
                )
            }

            // ===== Formulir Pendaftaran =====
            composable(route = Navigasi.Formulirku.name) { // Mendefinisikan rute untuk halaman Formulir
                FormulirPendaftaran(
                    OnSubmitBtnClick = {
                        // Setelah tombol submit ditekan, navigasi ke halaman TampilData
                        navController.navigate(Navigasi.Detail.name) {
                            popUpTo(Navigasi.Formulirku.name) { inclusive = true } // Hapus Formulir dari stack
                            launchSingleTop = true // Pastikan tidak membuat layar ganda
                        }
                    }
                )
            }
        }
    }
}
