package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(var context : Context, factory:SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper (context,DATABASE_NAME,null,DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {

        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                PAKET_COL + " TEXT," +
                HARGA_COL + " INT " + ")")


        db.execSQL(query)


    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }


    fun addName(name: String, paket: String, Harga: Int) {


        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(PAKET_COL, paket)
        values.put(HARGA_COL, Harga)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun delete(name: String) {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME WHERE $NAME_COl = '$name'")
    }


    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }

    companion object {
        private val DATABASE_NAME = "coba"
        private val DATABASE_VERSION = 4
        val TABLE_NAME = "tabel_coba"
        val ID_COL = "id"
        val NAME_COl = "name"
        val PAKET_COL = "paket"
        val HARGA_COL = "harga"



    }
}