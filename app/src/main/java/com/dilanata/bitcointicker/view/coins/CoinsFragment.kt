package com.dilanata.bitcointicker.view.coins

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dilanata.bitcointicker.R
import com.dilanata.bitcointicker.common.BaseVMFragment
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.util.Constants
import com.dilanata.bitcointicker.util.gone
import com.dilanata.bitcointicker.util.visible
import com.dilanata.bitcointicker.view.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_coins.*
import kotlinx.android.synthetic.main.fragment_markets.*

class CoinsFragment : BaseVMFragment<CoinsViewModel>(), CoinAdapter.OnCoinClickListener {

    private lateinit var  adapter: CoinAdapter
    override fun getViewModel(): Class<CoinsViewModel> = CoinsViewModel::class.java

    private lateinit var listCoin : List<CryptoModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coins, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = CoinAdapter()

       // rv_coins.layoutManager= LinearLayoutManager(activity)
        adapter.setOnCoinClickListener(this)

        listCoin=  listOf()
        viewModel.getCoins()?.observe(this, Observer {
            listCoin += it
            if(listCoin.isNotEmpty()){
                adapter.submitList(listCoin)
                coins_recyclerview.adapter=adapter
            }

            Log.e("dataa",it.toString())

            coins_recyclerview.visible()
            coins_progressbar.gone()
        })
    }


    override fun onCoinClick(coin: CryptoModel) {
        val intent = Intent(activity, DetailActivity::class.java)
       intent.putExtra(Constants.EXTRA_COIN, coin)
        startActivity(intent)
    }
}