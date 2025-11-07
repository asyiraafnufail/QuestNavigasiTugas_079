package com.example.tugasnavigasi.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.tugasnavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    onGoFormulir: () -> Unit,   // ke Formulirku
    onGoSplash: () -> Unit      // ke Splash (Beranda)
){
    val items = listOf(
        Pair(stringResource(id = R.string.nama_lengkap), "Contoh Nama"),
        Pair(stringResource(id = R.string.jenis_kelamin), "Lainnya"),
        Pair(stringResource(id = R.string.aLamat), "Yogyakarta")
    )
}