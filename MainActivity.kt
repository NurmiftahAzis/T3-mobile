package com.example.t3_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi View
        val etNama = findViewById<EditText>(R.id.etNama)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val cbMemasak = findViewById<CheckBox>(R.id.cbMemasak)
        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString()

            // 1. Validasi Nama Kosong
            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. Ambil data Jenis Kelamin
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val rbGender = findViewById<RadioButton>(selectedGenderId)
            val gender = rbGender.text.toString()

            // 3. Ambil data Hobi (List Checkbox)
            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbCoding.isChecked) hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")
            if (cbMemasak.isChecked) hobiList.add("Memasak")

            val hobi = if (hobiList.isEmpty()) "Tidak ada hobi" else hobiList.joinToString(", ")

            // 4. Tampilkan Hasil
            val hasil = """
                Nama      : $nama
                Kelamin  : $gender
                Hobi       : $hobi
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}