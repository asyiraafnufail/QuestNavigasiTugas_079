package com.example.tugasnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasnavigasi.view.FormulirPendaftaran
import com.example.tugasnavigasi.view.TampilData
import com.example.tugasnavigasi.view.SplashScreen

enum class Navigasi {
    Formulirku,
    Detail,
    Splash
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier // Menambahkan modifier untuk parameter yang lebih fleksibel
) {
    Scaffold { isiRuang ->
        // NavHost untuk menangani navigasi antar layar
        NavHost(
            navController = navController,
            startDestination = Navigasi.Splash.name, // Memulai dengan SplashScreen
            modifier = Modifier.padding(isiRuang)
        ) {
            // Splash Screen
            composable(route = Navigasi.Splash.name) {
                SplashScreen(
                    onSubmitClick = {
                        // Navigasi ke TampilData dari SplashScreen
                        navController.navigate(Navigasi.Detail.name) {
                            popUpTo(Navigasi.Splash.name) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }

            // TampilData Screen
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onGoFormulir = {
                        // Navigasi ke Formulir Pendaftaran tanpa data
                        navController.navigate(Navigasi.Formulirku.name) {
                            popUpTo(Navigasi.Detail.name) { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                    onGoSplash = {
                        // Kembali ke Splash (Beranda)
                        navController.navigate(Navigasi.Splash.name) {
                            popUpTo(Navigasi.Splash.name) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }

            // Formulir Pendaftaran
            composable(route = Navigasi.Formulirku.name) {
                FormulirPendaftaran(
                    OnSubmitBtnClick = {
                        // Setelah submit, kembali ke TampilData
                        navController.navigate(Navigasi.Detail.name) {
                            popUpTo(Navigasi.Formulirku.name) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
