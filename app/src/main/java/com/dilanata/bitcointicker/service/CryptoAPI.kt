package com.dilanata.bitcointicker.service

import com.dilanata.bitcointicker.model.coins.CryptoModel
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface CryptoAPI{

    //curl -X GET "https://api.coingecko.com/api/v3/coins/list" -H "accept: application/json"

    @GET("coins/list")
    fun getData() : Observable<List<CryptoModel>>
    //fun getData(): Call<List<CryptoModel>>
}