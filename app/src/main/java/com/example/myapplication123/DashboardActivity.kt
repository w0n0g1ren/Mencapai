package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardActivity : AppCompatActivity() {
    private lateinit var Name : TextView
    private lateinit var Berat : TextView
    private lateinit var Harga : TextView
    private lateinit var tambah : Button
    private lateinit var hapus: Button
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val imageList = listOf<Image>(
            Image(R.drawable.gambar1,
                "KILAT",
                "Kami menggunakan mesin cuci yang memiliki effisiensi tinggi dalam pengerjaan dan membuat pakaian dapat dicuci dengan cepat dan bersih. Sehingga kami dapat memberikan pelayanan antar pagi sebelum jam 8 lalu diambil sore atau antar sore diambil pagi, dalam layanan kami disebut Paket Kilat."
            ),
            Image(R.drawable.gambar2,
                "ON-TIME",
                "Kami memiliki sistem pengeringan menggunakan mesin pengering tersendiri yang dimana dapat meminimalisir pesanan tidak selesai pada waktunya."
            ),
            Image(R.drawable.gambar3,
                "IRON MEN",
                "Bagi kalian yang merasa ada waktu untuk mencuci tapi tidak ada waktu menyetrika pakaian, kami menawarkan anda untuk  memilih Paket Iron Men dimana paket ini melayani setrika saja."
            ),
            Image(R.drawable.gambar4,
                "SYAHDU",
                "Kami juga memiliki Paket Syahdu dimana pebgerjaanya dilakukan selama 2 hari (santuy). Selain itu kami juga melayani mencuci berbagai pakaian dari yang berbahan tipis sampai yang berbahan tebal."
            ),
        )
        val RecyclerView = findViewById<RecyclerView>(R.id._imageRecycleView)
        RecyclerView.layoutManager = LinearLayoutManager(this)
        RecyclerView.setHasFixedSize(true)
        RecyclerView.adapter = ImageAdapter(this, imageList){
            val intent= Intent (this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        tambah = findViewById(R.id.buttontambah)
        hapus = findViewById(R.id.buttonhapus)

        tambah.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        hapus.setOnClickListener {
            val intent = Intent(this,Hapus::class.java)
            startActivity(intent)
        }



        Name = findViewById(R.id.Name)
        Berat = findViewById(R.id.Paket)
        Harga = findViewById(R.id.Harga)
        val db = DBHelper(this, null)
        val cursor = db.getName()
        if( cursor!!.moveToFirst()){
            do {
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
                Berat.append(cursor.getString(cursor.getColumnIndex(DBHelper.PAKET_COL)) + "\n")
                Harga.append(cursor.getString(cursor.getColumnIndex(DBHelper.HARGA_COL)) + "\n")

            }while(cursor.moveToNext())
        }
        cursor.close()



    }


}