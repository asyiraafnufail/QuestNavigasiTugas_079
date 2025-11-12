package com.example.tugasnavigasi // Menentukan package tempat file ini berada

import android.annotation.SuppressLint // Mengimpor anotasi untuk menonaktifkan peringatan lint tertentu
import android.os.Bundle // Digunakan untuk menyimpan dan memulihkan data saat activity dibuat
import androidx.activity.ComponentActivity // Kelas dasar untuk activity berbasis Jetpack Compose
import androidx.activity.compose.setContent // Digunakan untuk menampilkan UI Compose pada activity
import androidx.activity.enableEdgeToEdge // Mengaktifkan tampilan layar penuh tanpa batas tepi (edge-to-edge)
import androidx.compose.foundation.layout.fillMaxSize // Modifier untuk membuat elemen mengisi seluruh ukuran layar
import androidx.compose.material3.Scaffold // Struktur dasar layout Compose dengan slot untuk topBar, bottomBar, dsb.
import androidx.compose.ui.Modifier // Objek untuk memodifikasi tampilan composable (misalnya ukuran, padding, warna)
import com.example.tugasnavigasi.DataApp // Mengimpor fungsi/composable DataApp dari package yang sama
import com.example.tugasnavigasi.ui.theme.TugasNavigasiTheme // Mengimpor tema kustom aplikasi

class MainActivity : ComponentActivity() { // Mendefinisikan kelas MainActivity sebagai activity utama aplikasi
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // Menonaktifkan peringatan lint terkait padding Scaffold
    override fun onCreate(savedInstanceState: Bundle?) { // Fungsi yang dipanggil pertama kali saat activity dibuat
        super.onCreate(savedInstanceState) // Memanggil fungsi onCreate() dari superclass
        enableEdgeToEdge() // Mengaktifkan mode tampilan layar penuh (tanpa batas tepi)
        setContent { // Menentukan tampilan UI menggunakan Jetpack Compose
            TugasNavigasiTheme { // Menerapkan tema aplikasi ke seluruh konten UI
                Scaffold(modifier = Modifier.fillMaxSize()) { // Membuat struktur layout dasar yang memenuhi layar
                    DataApp(modifier = Modifier) // Menampilkan composable utama bernama DataApp
                }
            }
        }
    }
}
