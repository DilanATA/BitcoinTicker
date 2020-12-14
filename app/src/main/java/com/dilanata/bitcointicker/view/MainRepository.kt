package com.dilanata.bitcointicker.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dilanata.bitcointicker.data.remote.APIClient
import com.dilanata.bitcointicker.data.remote.ApiService
import com.dilanata.bitcointicker.model.coins.CryptoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private val apiService: ApiService by lazy {APIClient.getApiService()}
    private var coins = mutableListOf<CryptoModel>()
    private var cryptoModels: ArrayList<CryptoModel>? = null

    fun getCoins(): LiveData<List<CryptoModel>>?{
        val coinsLiveData: MutableLiveData<List<CryptoModel>> = MutableLiveData()
        apiService.getData().enqueue(object: Callback<List<CryptoModel>>{

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                Log.e("getDatas", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                //coinsLiveData.value = response.body()?.coins
                if(response.code()==200){
                    Log.e("dddd", response.body()?.get(0).toString())
                    coinsLiveData.value = response.body()
                }

            }

        })
        return coinsLiveData
    }
}