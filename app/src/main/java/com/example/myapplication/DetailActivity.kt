package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.checkout.PilihBangkuActivity
//import com.example.myapplication.home.dashboard.PlaysAdapter
import com.example.myapplication.home.model.Menu
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.NumberFormat
import java.util.*


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Menu>("data")


        tv_nama.text = data.nama
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        tv_harga.setText(formatRupiah.format(data.harga!!.toDouble()))


        Glide.with(this)
            .load(data.poster)
            .into(iv_poster)

        btn_pilih_bangku.setOnClickListener {
            val intent = Intent(this@DetailActivity,
                PilihBangkuActivity::class.java).putExtra("data", data)
            startActivity(intent)
        }

        iv_back.setOnClickListener {
            finish()
        }

    }


}
