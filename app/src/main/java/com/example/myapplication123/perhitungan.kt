package com.example.myapplication123

class perhitungan {

    fun hitung (kg : Int , jenis : String) : Int{

        var produk : Int = if(jenis == "Kilat(antar pagi ambil sore)"){
            15000
        }else if (jenis == "Syahdu (diambil setelah 2 hari)"){
            10000
        }else if(jenis == "Iron Men (Setrika saja)"){
            7000
        }else{

        }as Int

        var totalan = produk * kg
        return totalan
    }
}