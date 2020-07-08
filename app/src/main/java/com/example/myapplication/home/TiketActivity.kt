package com.example.myapplication.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagicode.bwamov.home.TiketAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.checkout.model.Checkout
import kotlinx.android.synthetic.main.activity_tiket.*


class TiketActivity : AppCompatActivity() {

    private var dataList = ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

//        val data = intent.getParcelableExtra<Film>("data")
//
//        tv_title.text = data.judul
//        tv_genre.text = data.genre
//        tv_rate.text = data.rating
//
//        Glide.with(this)
//            .load(data.poster)
//            .into(iv_poster_image)

        rc_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Checkout("C1",""))
        dataList.add(Checkout("C2",""))

        rc_checkout.adapter = TiketAdapter(dataList) {
        }

    }
}
