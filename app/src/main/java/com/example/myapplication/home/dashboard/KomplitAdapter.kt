package com.example.myapplication.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.checkout.model.Order
import com.example.myapplication.home.model.Menu


class KomplitAdapter(private var data: ArrayList<Menu>,
                     private val listener: (Menu) -> Unit)
    : RecyclerView.Adapter<KomplitAdapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_item_coming_soon, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.tv_kursi)
//        private val tvGenre: TextView = view.findViewById(R.id.tv_genre)
        private val tvRate: TextView = view.findViewById(R.id.tv_rate)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data: Menu, listener: (Menu) -> Unit, context: Context, position: Int) {

            tvTitle.text = data.nama
//            tvGenre.text = data.jenis
            tvRate.text = data.harga

            Glide.with(context)
                .load(data.poster)
                .into(tvImage);
            var status:Boolean=false
            var totalk:Int=0
            var dataList= ArrayList<Order>()
            itemView.setOnClickListener {
                if (status) {
                    itemView.setBackgroundResource(R.drawable.shape_background_blue)
                    status = false
                    totalk -=1


                } else {
                    itemView.setBackgroundResource(R.drawable.shape_background_menu)
                    status = true
                    totalk +=1
                    val datao=Order(data.nama,data.harga,"1")
                    dataList.add(datao)
//                    belitiket(total)
//
//                    val data = Checkout("A1")
//                    dataList.add(data)
                }
            }
        }

    }

}

