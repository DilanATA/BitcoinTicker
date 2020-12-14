package com.dilanata.bitcointicker.view.coins

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.view.MainRepository

class CoinsViewModel : ViewModel() {
    private val repository: MainRepository by lazy {MainRepository()}

    fun getCoins() : LiveData<List<CryptoModel>>? = repository.getCoins()
}