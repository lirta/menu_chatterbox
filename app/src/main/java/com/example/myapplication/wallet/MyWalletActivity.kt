package com.example.myapplication.wallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.utils.Preferences
import com.example.myapplication.wallet.adapter.WalletAdapter
import com.example.myapplication.wallet.model.Wallet
import kotlinx.android.synthetic.main.activity_my_wallet.*


class MyWalletActivity : AppCompatActivity() {

    private var dataList = ArrayList<Wallet>()
    private var total:Int = 0

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet)

        dataList.add(
            Wallet(
                "Avengers Returns",
                "Sabtu 12 Jan, 2020",
                7000.0,
                "0"
            )
        )
        dataList.add(
            Wallet(
                "Toup Up",
                "Sabtu 12 Jan, 2020",
                90000.0,
                "1"
            )
        )
        dataList.add(
            Wallet(
                "Avengers Returns",
                "Sabtu 12 Jan, 2020",
                7000.0,
                "0"
            )
        )
        dataList.add(
            Wallet(
                "Avengers Returns",
                "Sabtu 12 Jan, 2020",
                7000.0,
                "0"
            )
        )

        rv_transaksi.layoutManager = LinearLayoutManager(this)
        rv_transaksi.adapter = WalletAdapter(dataList) {
        }

        btn_top_up.setOnClickListener {
            startActivity(Intent(this@MyWalletActivity, MyWalletTopUpActivity::class.java))
        }
    }

}
