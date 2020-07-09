package com.example.myapplication.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagicode.bwamov.home.TiketAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.checkout.model.Order
import com.example.myapplication.home.model.Menu
import com.example.myapplication.utils.Preferences
import kotlinx.android.synthetic.main.activity_tiket.*


class TiketActivity : AppCompatActivity() {

    private var dataList = ArrayList<Order>()
    private var total:Int = 0
    private lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Order>
        val data = intent.getParcelableExtra<Menu>("data")

        tv_title.text = data.nama
//        tv_genre.text = data.genre
        tv_rate.text = data.harga
//
        Glide.with(this)
            .load(data.poster)
            .into(iv_poster_image)
        dataList.add(Order("Total Harus Dibayar", total.toString()))
        rc_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Order("C1",""))
        dataList.add(Order("C2",""))

        rc_checkout.adapter = TiketAdapter(dataList) {
        }

    }
}
