package com.dilanata.bitcointicker.model.detail

import com.google.gson.annotations.SerializedName

data class CryptoDetailModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("image")
    var image : String,
    @SerializedName("current_price")
    var current_price : String,
    @SerializedName("price_change_24h")
    var price_change_24h : String
)