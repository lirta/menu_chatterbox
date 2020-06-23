package com.example.myapplication.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Minuman (
    var nama: String ?="",
    var harga: String ?="",
    var jenis: String ?="",
    var poster: String ?=""
): Parcelable