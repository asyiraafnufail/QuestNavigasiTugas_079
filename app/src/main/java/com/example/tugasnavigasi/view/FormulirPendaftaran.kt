package com.example.tugasnavigasi.view // Menentukan package tempat file ini berada

// ===== Import library Jetpack Compose yang digunakan =====
import androidx.compose.foundation.background // Untuk memberi warna latar belakang
import androidx.compose.foundation.layout.* // Untuk mengatur tata letak (Column, Row, Spacer, dsb.)
import androidx.compose.foundation.selection.selectable // Untuk membuat elemen bisa dipilih (seperti radio button)
import androidx.compose.foundation.shape.RoundedCornerShape // Untuk membuat bentuk dengan sudut membulat
import androidx.compose.material3.* // Mengimpor komponen Material Design 3 (Button, Text, Card, dsb.)
import androidx.compose.runtime.* // Untuk state management (remember, mutableStateOf, dll.)
import androidx.compose.ui.Alignment // Untuk mengatur posisi elemen secara horizontal/vertikal
import androidx.compose.ui.Modifier // Untuk memodifikasi tampilan composable
import androidx.compose.ui.graphics.Color // Untuk mendefinisikan warna
import androidx.compose.ui.text.font.FontWeight // Untuk mengatur ketebalan teks
import androidx.compose.ui.text.style.TextAlign // Untuk mengatur perataan teks
import androidx.compose.ui.unit.dp // Satuan ukuran density-independent pixel
import androidx.compose.ui.unit.sp // Satuan ukuran font (scale-independent pixel)

// ===== Fungsi utama untuk menampilkan Formulir Pendaftaran =====
@Composable
fun FormulirPendaftaran(
    OnSubmitBtnClick: () -> Unit // Fungsi callback yang dijalankan saat tombol submit ditekan
){
    // ===== State untuk menampung input pengguna =====
    var nama by remember { mutableStateOf("") } // Menyimpan input nama
    var alamat by remember { mutableStateOf("") } // Menyimpan input alamat
    var jenisKelamin by remember { mutableStateOf("") } // Menyimpan pilihan jenis kelamin
    var status by remember { mutableStateOf("") } // Menyimpan pilihan status perkawinan

    // ===== State tambahan (tidak digunakan untuk navigasi di sini) =====
    var hasilNama by remember { mutableStateOf("") }
    var hasilJK by remember { mutableStateOf("") }
    var hasilAlamat by remember { mutableStateOf("") }
    var hasilStatus by remember { mutableStateOf("") }

    // ===== Daftar pilihan untuk RadioButton =====
    val genderList = listOf("Laki-laki", "Perempuan") // Pilihan jenis kelamin
    val statusList = listOf("Janda", "Lajang", "Duda") // Pilihan status perkawinan

    // ===== Struktur tampilan utama =====
    Column(
        modifier = Modifier
            .fillMaxSize() // Mengisi seluruh layar
            .padding(24.dp), // Memberi jarak dari tepi layar
        horizontalAlignment = Alignment.CenterHorizontally // Semua elemen diratakan ke tengah horizontal
    ){
        // ===== Judul Form =====
        Text(
            text = "Formulir Pendaftaran",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth() // Lebar penuh
                .background(Color(0xFF9575CD), RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)) // Latar ungu muda dengan sudut atas membulat
                .padding(16.dp) // Jarak di dalam latar
        )

        // ===== Kartu utama berisi input =====
        Card(
            modifier = Modifier.fillMaxWidth(), // Lebar penuh
            shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp), // Sudut bawah membulat
            colors = CardDefaults.cardColors(containerColor = Color.White), // Warna latar kartu putih
            elevation = CardDefaults.cardElevation(6.dp) // Memberi efek bayangan lembut
        ){
            Column(modifier = Modifier.padding(16.dp)) {

                // ===== Input Nama =====
                Text("NAMA LENGKAP", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it }, // Menyimpan nilai yang diketik
                    placeholder = { Text("Isian nama lengkap") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                // ===== Pilihan Jenis Kelamin =====
                Text("JENIS KELAMIN", fontWeight = FontWeight.Bold)
                genderList.forEach { item -> // Loop untuk membuat RadioButton untuk setiap pilihan
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = jenisKelamin == item, // Tandai jika pilihan aktif
                                onClick = { jenisKelamin = item } // Simpan pilihan pengguna
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically // Rata tengah vertikal
                    ) {
                        RadioButton(
                            selected = jenisKelamin == item,
                            onClick = { jenisKelamin = item }
                        )
                        Text(item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // ===== Pilihan Status Perkawinan =====
                Text("STATUS PERKAWINAN", fontWeight = FontWeight.Bold)
                statusList.forEach { item -> // Loop untuk membuat RadioButton setiap pilihan status
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = status == item,
                                onClick = { status = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = status == item,
                            onClick = { status = item }
                        )
                        Text(item)
                    }
                }

                // ===== Input Alamat =====
                Spacer(modifier = Modifier.height(8.dp))
                Text("ALAMAT", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it }, // Simpan input alamat
                    placeholder = { Text("Alamat lengkap") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                // ===== Tombol Submit =====
                Button(
                    onClick = OnSubmitBtnClick, // Menjalankan aksi saat tombol ditekan
                    modifier = Modifier
                        .fillMaxWidth() // Tombol selebar layar
                        .height(48.dp), // Tinggi tombol
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6200EE), // Warna tombol ungu
                        contentColor = Color.White // Warna teks putih
                    )
                ) {
                    Text(text = "Submit") // Teks tombol
                }
            }
        }
    }
}
