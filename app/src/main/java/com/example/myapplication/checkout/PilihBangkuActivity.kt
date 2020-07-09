package com.example.myapplication.checkout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.checkout.model.Checkout
import com.example.myapplication.checkout.model.Order
import com.example.myapplication.home.model.Menu
import kotlinx.android.synthetic.main.activity_pilih_bangku.*


class PilihBangkuActivity : AppCompatActivity() {

    var statusA3:Boolean = false
    var statusA4:Boolean = false
    var total:Int = 0

    private var dataList = ArrayList<Order>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_bangku)

        val data = intent.getParcelableExtra<Menu>("data")

        tv_kursi.text = data.nama

        a3.setOnClickListener {
            if (statusA3) {
                a3.setImageResource(R.drawable.ic_rectangle_empty)
                statusA3 = false
                total -=1
                belitiket(total)
                dataList.remove(Order("A3",data.harga))
            } else {
                a3.setImageResource(R.drawable.ic_rectangle_selected)
                statusA3 = true
                total +=1
                belitiket(total)

                val data = Order("A3",data.harga)
                dataList.add(data)
            }
        }

        a4.setOnClickListener {
            if (statusA4) {
                a4.setImageResource(R.drawable.ic_rectangle_empty)
                statusA4 = false
                total -=1
                belitiket(total)
                dataList.remove(Order("A4",data.harga))
            } else {
                a4.setImageResource(R.drawable.ic_rectangle_selected)
                statusA4 = true
                total +=1
                belitiket(total)

                val data = Order("A4",data.harga)
                dataList.add(data)
            }
        }

        btn_home.setOnClickListener {

                val intent = Intent(
                    this,
                    CheckoutActivity::class.java
                ).putExtra("data", dataList)
                startActivity(intent)
        }

    }

    private fun belitiket(total:Int) {
        if (total == 0) {
            btn_home.setText("Oder Sekarang")
            btn_home.visibility = View.INVISIBLE
        } else {
            btn_home.setText("Oder Sekarang ("+total+")")
            btn_home.visibility = View.VISIBLE
        }

    }
}