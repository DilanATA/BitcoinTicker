package com.dilanata.bitcointicker.view.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.model.detail.CoinDetailModel
import com.dilanata.bitcointicker.model.detail.CryptoDetailModel

class DetailViewModel(app: Application): AndroidViewModel(app) {
    private val repository : DetailRepository by lazy { DetailRepository(app.applicationContext) }

    fun getCoinDetail(coinId : String): LiveData<CoinDetailModel> = repository.getDetailCoin(coinId)

    //fun getCryptoDetail(coinId: String) : LiveData<CryptoDetailModel> = repository.getDetailCrypto(coinId)
/*
    fun InsertCoin(coin: CryptoModel?) = repository.insertCoin(coin)

    fun deleteCoin(coin: CryptoModel?) = repository.deleteCoin(coin)

    fun getSingleCoin(coinId: String?) : LiveData<CryptoModel> = repository.getSingleMovie(coinId)

    fun getAllCoins(): LiveData<List<CryptoModel>> = repository.getAllCoins()*/
}