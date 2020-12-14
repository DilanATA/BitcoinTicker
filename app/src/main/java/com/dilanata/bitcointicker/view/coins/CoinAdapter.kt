package com.dilanata.bitcointicker.view.coins

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dilanata.bitcointicker.databinding.RvCoinsItemsBinding
import com.dilanata.bitcointicker.model.coins.CryptoModel

class CoinAdapter : ListAdapter<CryptoModel, CoinAdapter.ViewHolder>(DIFF_CALBACK) {

    private lateinit var onCoinClickListener: OnCoinClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.create(LayoutInflater.from(parent.context), parent, onCoinClickListener)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =holder.bind(getItem(position))

    fun setOnCoinClickListener(onCoinClickListener: OnCoinClickListener){
        this.onCoinClickListener=onCoinClickListener
    }

    class ViewHolder(val binding: RvCoinsItemsBinding, onCoinClickListener: OnCoinClickListener) : RecyclerView.ViewHolder(binding.root) {
        init{
            binding.root.setOnClickListener{
                onCoinClickListener.onCoinClick(binding.coin!!)
            }
        }
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup, onCoinClickListener: OnCoinClickListener): ViewHolder {
                val itemCoinbinding = RvCoinsItemsBinding.inflate(inflater, parent, false)
                return ViewHolder(itemCoinbinding, onCoinClickListener)
            }
        }

        fun bind(coinModel: CryptoModel){
            binding.coin = coinModel
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALBACK = object : DiffUtil.ItemCallback<CryptoModel>() {
            override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean =
                oldItem.coinId == newItem.coinId

            override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean =
                oldItem.symbol == newItem.symbol

        }
    }

    interface OnCoinClickListener{
       fun onCoinClick(coin: CryptoModel)
    }
}