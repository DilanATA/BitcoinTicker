package com.dilanata.bitcointicker.model.detail

import com.google.gson.annotations.SerializedName

data class CoinDetailModel (
    @SerializedName("id")
    var id: String,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("name")
    var name :  String,
    @SerializedName("hashing_algorithm")
    var hashing_algorithm: String,
    @SerializedName("image")
    var image : String,
    @SerializedName("description")
    var description : String,

    )