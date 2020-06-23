package com.example.myapplication.wallet

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_my_wallet_top_up.*


class MyWalletTopUpActivity : AppCompatActivity() {

    private var status10k:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet_top_up)

        btn_top_up.setOnClickListener {
            startActivity(Intent(this@MyWalletTopUpActivity, MyWalletSuccessActivity::class.java))
        }

        tv_10k.setOnClickListener {
            if (status10k) {
                deselectMoney(tv_10k)

            } else {
                selectMoney(tv_10k  )
            }
        }

        tv_20k.setOnClickListener {

        }

        tv_30k.setOnClickListener {

        }

    }

    private fun selectMoney(textview : TextView) {
        textview.setTextColor(resources.getColor(R.color.colorPink))
        textview.setBackgroundResource(R.drawable.shape_line_red)
        status10k = true
    }

    private fun deselectMoney(textview : TextView) {
        textview.setTextColor(resources.getColor(R.color.colorWhite))
        textview.setBackgroundResource(R.drawable.shape_line_white)
        status10k = false

    }

}
