package com.example.myapplication123

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val imageSrc: Int,
    val imageTitle: String,
    val imageDesc: String
) : Parcelable