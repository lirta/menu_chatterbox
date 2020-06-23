package com.example.myapplication.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.home.dashboard.ComingSoonAdapter
import com.example.myapplication.home.model.Minuman
import com.example.myapplication.utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_tiket.*


/**
 * A simple [Fragment] subclass.
 */
class TiketFragment : Fragment() {

//    private lateinit var preferences: Preferences
//    lateinit var mDatabase: DatabaseReference
//
//    private var dataList = ArrayList<Minuman>()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tiket, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        preferences = Preferences(activity!!.applicationContext)
//        mDatabase = FirebaseDatabase.getInstance().getReference("Minuman")
//
//        rc_tiket.layoutManager = LinearLayoutManager(context!!.applicationContext)
//        getData()
//
//    }
//
//    private fun getData() {
//        mDatabase.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//                dataList.clear()
//                for (getdataSnapshot in dataSnapshot.getChildren()) {
//
//                    val minuman = getdataSnapshot.getValue(Minuman::class.java!!)
//                    dataList.add(minuman!!)
//                }
//
//                rc_tiket.adapter = ComingSoonAdapter(dataList) {
//                    val intent = Intent(context,
//                        TiketActivity::class.java).putExtra("data", it)
//                    startActivity(intent)
//                }
//
//                tv_total.setText(dataList.size.toString() +" Movies")
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
//            }
//        })
//    }

}
