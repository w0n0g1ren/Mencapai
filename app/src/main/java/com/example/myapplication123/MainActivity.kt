package com.example.myapplication123


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    private lateinit var addName : Button

    private lateinit var enterName : EditText
    private lateinit var enterBerat : EditText
    private lateinit var Spinner_1 : Spinner


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addName = findViewById(R.id.buttonsimpan)
        enterName = findViewById(R.id.enterName)
        enterBerat = findViewById(R.id.enterberat)
        Spinner_1 = findViewById(R.id.spinner)




        addName.setOnClickListener{

            val spinner = Spinner_1.selectedItem.toString()

            val db = DBHelper(this, null)

            val name = enterName.text.toString()
            val berat = enterBerat.text.toString().toInt()

            val hitung =perhitungan()
            var produk : String = if(spinner == "Kilat(antar pagi ambil sore)"){
                "KILAT"
            }else if (spinner == "Syahdu (diambil setelah 2 hari)"){
                "SYAHDU"
            }else if(spinner == "Iron Men (Setrika saja)"){
                "IRON MAN"
            }else{

            }as String

                var totalan = hitung.hitung(berat,spinner)

                db.addName(name, produk , totalan)

                Toast.makeText(this,"Pesanan $name Tersimpan", Toast.LENGTH_LONG).show()

                enterName.text.clear()
                enterBerat.text.clear()

                val intent = Intent(this,DashboardActivity::class.java)
                startActivity(intent)
            }

        }

    }
