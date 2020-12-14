package com.dilanata.bitcointicker.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.dilanata.bitcointicker.R
import com.dilanata.bitcointicker.common.BaseActivity
import com.dilanata.bitcointicker.common.ViewPagerAdapter
import com.dilanata.bitcointicker.databinding.ActivityDetailBinding
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.util.Constants
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    private var isFav: Boolean ?= null
    override fun getLayoutRes(): Int = R.layout.activity_detail

    override fun getViewModel(): Class<DetailViewModel> = DetailViewModel::class.java

    private var coin: CryptoModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras.let {
            coin = it?.getParcelable(Constants.EXTRA_COIN)

         /*   checkFav()
            fav_coin.setOnClickListener{
                favourite()
            }*/
            Log.e("coin: ", coin?.symbol.toString())

          //  dataBinding.detailCoin.id  = coin.id
            viewModel.getCoinDetail(coin?.coinId.toString()).observe(this, Observer {
                dataBinding.detailCoin = it
            })
           /* viewModel.getCryptoDetail(coin?.id.toString()).observe(this, Observer {
                dataBinding.detailCrypto = it
            })*/

        }
    }

  /*  private fun favourite() {
        if(isFav!!){
            viewModel.deleteCoin(coin)
            Toast.makeText(this, "Favorilerden çıkarıldı", Toast.LENGTH_SHORT).show()
        }else {
            viewModel.InsertCoin(coin)
            Toast.makeText(this, "Favorilere eklendi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFav(){
    viewModel.getSingleCoin(coin?.coinId).observe(this, Observer {
        if(it != null){
            fav_coin.setImageResource(R.drawable.ic_selected_fav)
            isFav=true
        }
        else{
            fav_coin.setImageResource(R.drawable.fav_icon_default)
            isFav = false
        }
    })
}*/
}