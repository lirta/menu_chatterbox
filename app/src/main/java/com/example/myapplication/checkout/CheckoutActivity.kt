package com.example.myapplication.checkout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.checkout.adapter.CheckoutAdapter
import com.example.myapplication.checkout.model.Order
import com.example.myapplication.home.model.Menu
import com.example.myapplication.utils.Preferences
import kotlinx.android.synthetic.main.activity_checkout.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList


class CheckoutActivity : AppCompatActivity() {

    private var dataList = ArrayList<Order>()
    private var total:Int = 0

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Order>
        val data = intent.getParcelableExtra<Menu>("datas")
//
        for (a in dataList.indices){
            total += dataList[a].harga!!.toInt()
        }
//        total=data.harga!!.toInt()
//

        dataList.add(Order("Total Harus Dibayar",total.toString()))
//
        btn_order.setOnClickListener {
            val intent = Intent(this@CheckoutActivity,
                CheckoutSuccessActivity::class.java)
            startActivity(intent)

//            showNotif(data)
        }

        btn_home.setOnClickListener {
            finish()
        }
//
        rc_checkout.layoutManager = LinearLayoutManager(this)
        rc_checkout.adapter = CheckoutAdapter(dataList) {
        }
//
        if(preferences.getValues("saldo")!!.isNotEmpty()) {
            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            tv_saldo.setText(formatRupiah.format(preferences.getValues("saldo")!!.toDouble()))
            btn_order.visibility = View.VISIBLE
            textView3.visibility = View.INVISIBLE

        } else {
            tv_saldo.setText("Rp 0")
            btn_order.visibility = View.INVISIBLE
            textView3.visibility = View.VISIBLE
            textView3.text = "Saldo pada e-wallet kamu tidak mencukupi\n" +
                    "untuk melakukan transaksi"
        }
    }
//
//    private fun showNotif(datas: Menu) {
//        val NOTIFICATION_CHANNEL_ID = "channel_bwa_notif"
//        val context = this.applicationContext
//        var notificationManager =
//            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            val channelName = "BWAMOV Notif Channel"
//            val importance = NotificationManager.IMPORTANCE_HIGH
//
//            val mChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance)
//            notificationManager.createNotificationChannel(mChannel)
//        }
//
//        val mIntent = Intent(this, CheckoutSuccessActivity::class.java)
//        val bundle = Bundle()
//        bundle.putString("id", "id_film")
//        mIntent.putExtras(bundle)
//
//        val mIntent = Intent(this, TiketActivity::class.java)
//        val bundle = Bundle()
//        bundle.putParcelable("data", datas)
//        mIntent.putExtras(bundle)
//
//        val pendingIntent =
//            PendingIntent.getActivity(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
//        builder.setContentIntent(pendingIntent)
//            .setSmallIcon(R.drawable.logo_mov)
//            .setLargeIcon(
//                BitmapFactory.decodeResource(
//                    this.resources,
//                    R.drawable.logo_notification
//                )
//            )
//            .setTicker("notif bwa starting")
//            .setAutoCancel(true)
//            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
//            .setLights(Color.RED, 3000, 3000)
//            .setDefaults(Notification.DEFAULT_SOUND)
//            .setContentTitle("Sukses Terbeli")
//            .setContentText("Menu "+datas.nama+" berhasil kamu order. Enjoy the menu!")
//
//        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(115, builder.build())
//    }
}
