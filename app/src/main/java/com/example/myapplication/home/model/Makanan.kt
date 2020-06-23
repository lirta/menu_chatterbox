package com.example.myapplication.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Makanan (
    var nama: String ?="",
    var harga: String ?="",
    var poster: String ?=""
//    var desc: String ?="",
//    var director: String ?="",
//    var genre: String ?="",
//    var judul: String ?="",
//    var poster: String ?="",
//    var rating: String ?=""
): Parcelable