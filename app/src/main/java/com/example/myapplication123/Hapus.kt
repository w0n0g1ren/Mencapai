package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Hapus : AppCompatActivity() {
    private lateinit var hapus : Button
    private lateinit var nama : EditText


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hapus)

        hapus = findViewById(R.id.hapusbtn)
        nama = findViewById(R.id.enterNameHps)


        hapus.setOnClickListener {
            val db = DBHelper (this,null)
            var nama1 = nama.text.toString()

            db.delete(nama1)
            nama.text.clear()

            Toast.makeText(this,"Pesanan $nama1 Berhasil Dihapus",Toast.LENGTH_LONG).show()

            val intent = Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }




    }
}