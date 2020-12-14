package com.dilanata.bitcointicker.data.remote

import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.model.detail.CoinDetailModel
import com.dilanata.bitcointicker.model.detail.CryptoDetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface ApiService {

    @GET("coins/list")
    fun getData(): Call<List<CryptoModel>>



  //  @GET("coins/markets")
   // fun getDetailData(@Path("id") coinId: String) : Call<CryptoDetailModel>

    @GET("coins/{id}")
    fun getCoinDetailData(@Path("id") coinId: String) : Call<CoinDetailModel>
}