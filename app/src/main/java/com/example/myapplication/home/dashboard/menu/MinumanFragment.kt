package com.example.myapplication.home.dashboard.menu


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.DetailActivity

import com.example.myapplication.R
import com.example.myapplication.home.dashboard.MinumanAdapter
import com.example.myapplication.home.model.Minuman
import com.example.myapplication.utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.iv_profile
import kotlinx.android.synthetic.main.fragment_dashboard.tv_nama
import kotlinx.android.synthetic.main.fragment_minuman.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class MinumanFragment : Fragment() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference

    private var dataList = ArrayList<Minuman>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minuman, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(activity!!.applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("Minuman")

        tv_nama.setText(preferences.getValues("nama"))



        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profile)

        Log.v("tamvan", "url "+preferences.getValues("url"))
//
//        rv_now_playing.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_minuman.layoutManager = LinearLayoutManager(context!!.applicationContext)
        getData()

    }



    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val minuman = getdataSnapshot.getValue(Minuman::class.java!!)
                    dataList.add(minuman!!)
                }

                if (dataList.isNotEmpty()) {
//                    rv_now_playing.adapter = NowPlayingAdapter(dataList) {
//                        val intent = Intent(
//                            context,
//                            DetailActivity::class.java
//                        ).putExtra("data", it)
//                        startActivity(intent)
//                    }

                    rv_minuman.adapter = MinumanAdapter(dataList) {
                        val intent = Intent(
                            context,
                            DetailActivity::class.java
                        ).putExtra("data", it)
                        startActivity(intent)
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun currecy(harga:Double, textView: TextView) {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        textView.setText(formatRupiah.format(harga as Double))

    }



}
