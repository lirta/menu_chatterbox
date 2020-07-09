package com.example.myapplication.checkout.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order (
//    var nama: String ?="",
//    var harga: String ?="",
//    var total: String ?="",
    var kursi: String ?="",
    var harga: String ?=""

): Parcelable