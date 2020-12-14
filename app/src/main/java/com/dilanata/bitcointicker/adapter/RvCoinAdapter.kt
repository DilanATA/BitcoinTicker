package com.dilanata.bitcointicker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilanata.bitcointicker.R
import com.dilanata.bitcointicker.model.coins.CryptoModel
import kotlinx.android.synthetic.main.rv_coins_items.view.*

class RvCoinAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<RvCoinAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }
    class RowHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel: CryptoModel, listener : Listener){
            itemView.setOnClickListener{
                listener.onItemClick(cryptoModel)
            }
            itemView.coin_name.text = cryptoModel.name
            itemView.coin_symbol.text = cryptoModel.symbol
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_coins_items,parent,false)

        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], listener)
    }

    override fun getItemCount(): Int = cryptoList.count()
}